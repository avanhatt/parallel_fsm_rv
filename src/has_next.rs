use rust_fsm::*;
use crate::utils::*;
use log::info;

#[cfg(target_arch = "x86_64")]
use core::arch::x86_64::*;

use std::io::BufWriter;
use std::fs::File;
use std::io::Write;

state_machine! {
  derive(Debug)
  FSM(initial)

  start => {
      next => violation,
      hasnext => safe,
  },
  safe => {
      next => start,
      hasnext => safe,
  },
  violation => {
      next => violation,
      hasnext => safe,
  },
}

const VIOLATION : State = 0;
pub const START : State = 1;
const SAFE : State  = 2;

const NEXT : Event = 0;
const HASNEXT : Event = 1;
const NUM_EVENTS : Event = 3;

fn transition(event : State) -> __m128i {
  let trans_vec = match event {
    NEXT => [
      VIOLATION,            // VIOLATION
      VIOLATION,            // START
      START,                // SAFE
    ].to_vec(),
    HASNEXT => [
      SAFE,                 // VIOLATION
      SAFE,                 // START
      SAFE,                 // SAFE
    ].to_vec(),
    _ => Vec::new()
  };
  to_m128i(trans_vec)
}

pub fn get_transitions() -> Vec<__m128i> {
  let mut transitions : Vec<__m128i> = Vec::new();
  for event in 0..NUM_EVENTS {
    transitions.push(transition(event));
  };
  transitions
}

pub fn match_trace(trace : Vec<String>) {
  info!("Running machine sequentially");
  let violations_file = File::create("violations.txt").unwrap();
  let mut writer = BufWriter::new(&violations_file);
  let mut machine: StateMachine<FSM> = StateMachine::new();
  for (i, event) in trace.iter().enumerate() {
    let _result = match event.as_str() {
      "next" => machine.consume(&FSMInput:next),
      "hasnext" => machine.consume(&FSMInput::hasnext),
      _ => Err(()),
    };
    match machine.state() {
      FSMState::violation => {
        let _ = writer.write(format!("\tViolation found on event {:?}, index {:?} ",
          event,
          i).as_bytes()).expect("Unable to write data");
      }
      _ => ()
    }
  };
  info!("Final state {:?}", machine.state());
}

pub fn trace_to_vec(trace : Vec<String>) -> Vec<i8> {
  trace.iter().map(|e|
    match e.as_str() {
      "next" => NEXT,
      "hasnext" => HASNEXT,
      _ => panic!("Unexpected event")
    }).collect()
}
