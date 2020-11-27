use rust_fsm::*;
use crate::utils::*;

#[cfg(target_arch = "x86_64")]
use core::arch::x86_64::*;

state_machine! {
  derive(Debug)
  FSM(initial)

  initial => {
      outputstreaminit => outputstreamcreated
  },
  outputstreamcreated => {
      write => writing,
      flush => flushed,
      close => closed,

      outputstreaminit => violation,
      tobytearray => violation,
      tostring => violation,
  },
  writing => {
      write => writing,
      flush => flushed,
      close => closed,

      outputstreaminit => violation,
      tobytearray => violation,
      tostring => violation,
  },
  flushed => {
      flush => flushed,
      write => writing,
      tobytearray => flushed,
      tostring => flushed,
      close => closed,

      outputstreaminit => violation,
  },
  closed => {
      tobytearray => closed,
      tostring => closed,

      write => violation,
      flush => violation,
      close => violation,
      outputstreaminit => violation,
  },
}

const VIOLATION : State = 0;
pub const INITIAL : State = 1;
const OUTPUTSTREAMCEATED : State  = 2;
const WRITING : State = 3;
const FLUSHED : State = 4;
const CLOSED : State = 5;

const INIT : Event = 0;
const TOBYTEARRAY : Event = 1;
const TOSTRING : Event = 2;
const WRITE: Event  = 3;
const FLUSH : Event = 4;
const CLOSE : Event = 5;

pub fn transition(event : State) -> __m128i {
  let trans_vec = match event {
    INIT => [
      VIOLATION,                // VIOLATION
      OUTPUTSTREAMCEATED,       // INITIAL
      VIOLATION,                // OUTPUTSTREAMCEATED
      VIOLATION,                // WRITING
      VIOLATION,                // FLUSHED
      VIOLATION,                // CLOSED
    ].to_vec(),
    TOBYTEARRAY => [
      VIOLATION,                // VIOLATION
      VIOLATION,                // INITIAL
      VIOLATION,                // OUTPUTSTREAMCEATED
      VIOLATION,                // WRITING
      FLUSHED,                  // FLUSHED
      CLOSED,                   // CLOSED
    ].to_vec(),
    TOSTRING => [
      VIOLATION,                // VIOLATION
      VIOLATION,                // INITIAL
      VIOLATION,                // OUTPUTSTREAMCEATED
      VIOLATION,                // WRITING
      FLUSHED,                  // FLUSHED
      CLOSED,                   // CLOSED
    ].to_vec(),
    WRITE => [
      VIOLATION,                // VIOLATION
      VIOLATION,                // INITIAL
      WRITING,                  // OUTPUTSTREAMCEATED
      WRITING,                  // WRITING
      WRITING,                  // FLUSHED
      VIOLATION,                // CLOSED
    ].to_vec(),
    FLUSH => [
      VIOLATION,                // VIOLATION
      VIOLATION,                // INITIAL
      FLUSHED,                  // OUTPUTSTREAMCEATED
      FLUSHED,                  // WRITING
      FLUSHED,                  // FLUSHED
      VIOLATION,                // CLOSED
    ].to_vec(),
    CLOSE => [
      VIOLATION,                // VIOLATION
      VIOLATION,                // INITIAL
      CLOSED,                   // OUTPUTSTREAMCEATED
      CLOSED,                   // WRITING
      CLOSED,                   // FLUSHED
      VIOLATION,                // CLOSED
    ].to_vec(),
    _ => Vec::new()
  };
  to_m128i(trans_vec)
}

pub fn match_trace(trace : Vec<String>) {
  println!("Running machine sequentially");
  let mut machine: StateMachine<FSM> = StateMachine::new();
  for (i, event) in trace.iter().enumerate() {
    let _result = match event.as_str() {
      "outputstreaminit" => machine.consume(&FSMInput::outputstreaminit),
      "write" => machine.consume(&FSMInput::write),
      "flush" => machine.consume(&FSMInput::flush),
      "close" => machine.consume(&FSMInput::close),
      "tobytearray" => machine.consume(&FSMInput::tobytearray),
      "tostring" => machine.consume(&FSMInput::tostring),
      _ => Err(()),
    };
    match machine.state() {
      FSMState::violation =>
        println!("\tViolation found on event {:?}, index {:?} ",
          event,
          i),
      _ => ()
    }
  };
  println!("Final state {:?}", machine.state());
}

pub fn trace_to_vec(trace : Vec<String>) -> Vec<i8> {
  trace.iter().map(|e|
    match e.as_str() {
      "outputstreaminit" => INIT,
      "write" => WRITE,
      "flush" => FLUSH,
      "close" => CLOSE,
      "tobytearray" => TOBYTEARRAY,
      "tostring" => TOSTRING,
      _ => panic!("Unexpected event")
    }).collect()
}
