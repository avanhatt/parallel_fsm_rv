use crate::utils::*;
use itertools::Itertools;

#[cfg(target_arch = "x86_64")]
use core::arch::x86_64::*;

use std::thread;

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


pub fn course_grained_parallel(init : State, input : Vec<Event>) {
  let cpus = num_cpus::get();
  let workers = std::cmp::min(cpus, 16);
  let chunk_size = input.len() / workers;
  println!("Running course grained algorithm with {:?} chunks of size {:?}", workers, chunk_size);

  // TODO: fix lifetime issue
  crossbeam::scope(|scope| {
    (0..workers).map(|i| scope.spawn(move |_| {
      let chunk = &input[i*chunk_size .. (i+1)*chunk_size - 1];
      println!("{:?} : {:?}", i, chunk)
    }))
  });
}