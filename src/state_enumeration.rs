use crate::utils::*;
use itertools::Itertools;
use std::io::BufWriter;
use std::fs::File;
use std::io::Write;

#[cfg(target_arch = "x86_64")]
use core::arch::x86_64::*;

// Pseudocode from the paper: https://dl.acm.org/doi/10.1145/2541940.2541988
// Base(State st, Input in) {
//   States S = Id;
//   for (i=0; i<in.len; i++) {
//     a = in[i];
//     S = S ⊗ T[a];
//     φ(a, S[st]);
//   }
// }
pub fn enumerative_transition(
    state : &State,
    input : &Vec<Event>,
    transitions : &Vec<__m128i>,
    offset : usize,
    file : &File)
    -> __m128i
{
  let mut states : __m128i = iden();
  let mut writer = BufWriter::new(file);
  for (i, event) in input.iter().enumerate() {
    let trans = transitions[*event as usize];
    states = gather(trans, states);

    // Check if there is a violation
    let states_as_vec = store_to_vec(states);
    let actual_state = states_as_vec[*state as usize];
    if actual_state == 0 {
      writer.write(format!("\tViolation found on event {:?}, index {:?} ",
        event,
        offset + i).as_bytes()).expect("Unable to write data");
    }
  };
  states
}

fn ceiling_div(a : usize, b : usize) -> usize {
  a/b + (a%b != 0) as usize
}

#[cfg(target_arch = "x86_64")]
pub fn course_grained_parallel(
  init : State,
  input : Vec<Event>,
  get_transitions : fn() -> Vec<__m128i>,
  par: std::option::Option<&str>)
{
  let cpus = num_cpus::get_physical();
  let workers = if let Some(p) = par { std::cmp::min(cpus, p.parse::<usize>().unwrap()) } else { cpus };
  let size = input.len();
  let chunk_size = ceiling_div(size, workers);
  let transitions = get_transitions();
  let read_transitions = &transitions;

  // Write violations out to a file
  let violations_file = File::create("violations.txt").unwrap();
  let violations_ref = &violations_file;

  // Split input into chunks per worker
  let chunks = input
    .into_iter()
    .chunks(chunk_size)
    .into_iter()
    .map(|c| {c.into_iter().collect_vec()})
    .collect_vec();

  let num_chunks = chunks.len();
  println!("Machine has {:?} physical cores", workers);
  println!("Running course grained algorithm with {:?} chunks of size <= {:?}",
    num_chunks,
    chunk_size);

  unsafe {
    // Run each chunk in parallel threads, using gather for fine-grained ILP
    println!("Running chunks in parallel to determine start states.");
    let states_per_chunk : Vec<__m128i> = crossbeam::scope(|scope| {
      let mut chunk_states : Vec<__m128i> = vec![_mm_setzero_si128(); num_chunks];
      for (i, chunk) in chunks.iter().enumerate() {
        let result = scope.spawn(move |_| {
          // println!("\tStarting thread {:?} : {:?}", i, chunk);
          let mut states = read_transitions[chunk[0] as usize];
          for event in chunk[1..].iter() {
            let trans = read_transitions[*event as usize];
            states = gather(trans, states);
          };
          states
        });
        chunk_states[i] = result.join().unwrap();
      }
      chunk_states
    }).unwrap();

    // Sequentially look up the start state for each chunk
    println!("Sequentially analyzing start states.");
    let mut start_states : Vec<State> = vec![-1; num_chunks];
    start_states[0] = init;
    for i in 1..num_chunks {
      let previous_start = start_states[i - 1];
      let states_as_vec = store_to_vec(states_per_chunk[i - 1]);
      start_states[i] = states_as_vec[previous_start as usize];
    }

    println!("\tStart states per chunk: {:?}", start_states);

    // Check for actual violations in parallel
    println!("Running chunks in parallel to with start states to find violations.");
    let _ = crossbeam::scope(|scope| {
      for (i, (chunk, start_state)) in chunks.iter().zip(start_states.iter()).enumerate() {
        scope.spawn(move |_| {
          enumerative_transition(&start_state,
                                chunk,
                                read_transitions,
                                i*chunk_size,
                                violations_ref)
        });
      }
    });
  }
}