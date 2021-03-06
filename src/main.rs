#![allow(non_camel_case_types)]

use log::info;

pub mod byte_array_output_stream_flush;
pub mod utils;
pub mod state_enumeration;

// Strum contains all the trait definitions
extern crate strum;
extern crate strum_macros;

extern crate clap;
use clap::{Arg, App};
use crate::byte_array_output_stream_flush::*;

fn main() {
  let matches = App::new("Parallel FSM for Runtime Verification")
                    .arg(Arg::with_name("INPUT")
                      .help("Sets the input file")
                      .required(true)
                      .index(1))
                    .arg(Arg::with_name("seq")
                      .long("seq")
                      .help("Run sequentially"))
                    .arg(Arg::with_name("par")
                      .long("par")
                      .takes_value(true)
                      .help("Parallelism factor (number of cores), defaults to
                        number of physical cores on the machine"))
                    .get_matches();

  use std::fs::File;
  use std::io::{self, BufRead};
  use std::path::Path;

  if matches.is_present("seq") && matches.is_present("par") {
    panic!("Cannot provide both sequential flag and parallelism factor")
  }

  fn read_lines<P>(filename: P) -> io::Result<io::Lines<io::BufReader<File>>>
  where P: AsRef<Path>, {
      let file = File::open(filename)?;
      Ok(io::BufReader::new(file).lines())
  }

  // Get a path string to parse a program.
  let path = matches.value_of("INPUT").unwrap();
  let lines = read_lines(path).expect("Failed to read the input file.");
  let trace = utils::to_trace(lines);
  info!("Trace has {:?} total events.", trace.len());

  if matches.is_present("seq") {
    byte_array_output_stream_flush::match_trace(trace);
    return;
  }

  // Get parallelism factor
  let par = matches.value_of("par");

  // Run parallel version
  let trace_par = trace_to_vec(trace);
  state_enumeration::course_grained_parallel(INITIAL, trace_par, get_transitions, par);
}

#[cfg(test)]
mod tests {
  use crate::utils::*;
  use log::info;
  use rust_fsm::*;
  #[cfg(target_arch = "x86_64")]
  use core::arch::x86_64::*;

  // Example RV traffic light spec using Rust's FSM library
  state_machine! {
    derive(Debug)
    TrafficFSM(Stopping)

    Stopping => {
      Yellow => Stopping,
      Red => Stopping,
      Green => Going
    },
    Going => {
      Green => Going,
      Yellow => Stopping,
      Red => Violation
    },
  }

  #[test]
  fn simple_traffic_light() {
    // Initialize the state machine. The state is `Stopping` now.
    let mut machine: StateMachine<TrafficFSM> = StateMachine::new();
    info!("Initial state {:?}", machine.state());

    // Consume the `Green` input.
    let _ = machine.consume(&TrafficFSMInput::Green);
    info!("Next state {:?}", machine.state());

    // Try red, which should fail
    let _ = machine.consume(&TrafficFSMInput::Red);
    info!("Next state {:?}", machine.state());

    let _ = machine.consume(&TrafficFSMInput::Yellow);
  }

// pub unsafe fn _mm_shuffle_epi8(a: __m128i, b: __m128i) -> __m128i
  #[test]
  #[cfg(target_arch = "x86_64")]
  fn test_simd() {
    unsafe {
      let a = _mm_set_epi8(10, 11, 12, 13, 14, 15, 16, 17,
                                               18, 19, 20, 21, 22, 23, 24, 25);
      let b = to_m128i([0, 1, 2, 3, 4, 5, 6, 7].to_vec());
      let c : __m128i = _mm_shuffle_epi8(a, b);
      let mut mem : [u8; 16] = [0; 16];
      _mm_storeu_si128(
        mem.as_mut_ptr() as *mut _,
        c,
      );
      info!("mem: {:?}", mem);
    }
  }

}
