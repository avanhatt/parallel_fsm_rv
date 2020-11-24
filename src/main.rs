#![allow(non_camel_case_types)]

pub mod byte_array_output_stream_flush;
pub mod utils;

// Strum contains all the trait definitions
extern crate strum;
extern crate strum_macros;

extern crate clap;
use clap::{Arg, App};

fn main() {
  let matches = App::new("Parallel FSM for Runtime Verification")
                    .arg(Arg::with_name("INPUT")
                      .help("Sets the input file")
                      .required(true)
                      .index(1))
                    .get_matches();

  use std::fs::File;
  use std::io::{self, BufRead};
  use std::path::Path;

  fn read_lines<P>(filename: P) -> io::Result<io::Lines<io::BufReader<File>>>
  where P: AsRef<Path>, {
      let file = File::open(filename)?;
      Ok(io::BufReader::new(file).lines())
  }

  // Get a path string to parse a program.
  let path = matches.value_of("INPUT").unwrap();
  let lines = read_lines(path).expect("Failed to read the input file.");
  let trace = utils::to_trace(lines);
  byte_array_output_stream_flush::match_trace(trace);
}

#[cfg(test)]
mod tests {
  use rust_fsm::*;

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
    println!("Initial state {:?}", machine.state());

    // Consume the `Green` input.
    let _ = machine.consume(&TrafficFSMInput::Green);
    println!("Next state {:?}", machine.state());

    // Try red, which should fail
    let _ = machine.consume(&TrafficFSMInput::Red);
    println!("Next state {:?}", machine.state());
  }

}
