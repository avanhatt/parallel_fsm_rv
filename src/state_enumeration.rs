use crate::utils::*;
use itertools::Itertools;

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
    _state : State,
    input : Vec<Event>,
    get_transitions : fn(State) -> __m128i)
    -> __m128i
{
  let mut states : __m128i = iden();
  for event in input.iter() {
      let trans = get_transitions(*event);
      states = gather(states, trans)
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
  get_transitions : fn(State) -> __m128i)
{
  let cpus = num_cpus::get();
  let workers = std::cmp::min(cpus, 16);
  let chunk_size = ceiling_div(input.len(), workers);

  // Split input into chunks per worker
  let chunks = input
    .into_iter()
    .chunks(chunk_size)
    .into_iter()
    .map(|c| {c.into_iter().collect_vec()})
    .collect_vec();

  let num_chunks = chunks.len();
  println!("Running course grained algorithm with {:?} chunks of size <= {:?}",
    num_chunks,
    chunk_size);

  unsafe {
    // Run each chunk in parallel threads, using gather for fine-grained ILP
    let states_per_chunk : Vec<__m128i> = crossbeam::scope(|scope| {
      let mut chunk_states : Vec<__m128i> = vec![_mm_setzero_si128(); num_chunks];
      for (i, chunk) in chunks.iter().enumerate() {
        let result = scope.spawn(move |_| {
          println!("{:?} : {:?}", i, chunk);
          let mut states = get_transitions(chunk[0]);
          for event in chunk[1..].iter() {
            let trans = get_transitions(*event);
            states = gather(states, trans)
          };
          states
        });
        chunk_states[i] = result.join().unwrap();
      }
      chunk_states
    }).unwrap();

    // Sequentially look up the start state for each chunk
    let mut start_states : Vec<State> = vec![-1; num_chunks];
    start_states[0] = init;
    for i in 1..num_chunks {
      let previous_start = start_states[i - 1];
      let mut states_as_vec : [i8; 16] = [0; 16];
      _mm_storeu_si128(
        states_as_vec.as_mut_ptr() as *mut _,
        states_per_chunk[i - 1],
      );
      start_states[i] = states_as_vec[previous_start as usize];
    }

    println!("{:?}", start_states);

  }
}