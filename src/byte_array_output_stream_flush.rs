use rust_fsm::*;
use crate::utils::*;

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
const INITIAL : State = 1;
const OUTPUTSTREAMCEATED : State  = 2;
const WRITING : State = 3;
const FLUSHED : State = 4;
const CLOSED : State = 5;

// const INIT : Event = 0;
// const TOBYTEARRAY : Event = 1;
// const TOSTRING : Event = 2;
// const WRITE: Event  = 3;
// const FLUSH : Event = 4;
// const CLOSE : Event = 5;

pub fn transition(state : State) -> Vec<State> {
  match state {
    INITIAL => [
      OUTPUTSTREAMCEATED
    ].to_vec(),
    OUTPUTSTREAMCEATED => [
      SET_ZERO,
      SET_ZERO,
      SET_ZERO,
      WRITING,
      FLUSHED,
      CLOSED
    ].to_vec(),
    WRITING => [
      SET_ZERO,
      SET_ZERO,
      SET_ZERO,
      WRITING,
      FLUSHED,
      CLOSED
    ].to_vec(),
    FLUSHED => [
      SET_ZERO,
      FLUSHED,
      FLUSHED,
      WRITING,
      FLUSHED,
      CLOSED
    ].to_vec(),
    CLOSED => [
      SET_ZERO,
      CLOSED,
      CLOSED
    ].to_vec(),
    _ => Vec::new()
  }
}


pub fn match_trace(trace : Vec<String>) {
  let mut machine: StateMachine<FSM> = StateMachine::new();
  for event in trace {
    let _result = match event.as_str() {
      "outputstreaminit" => machine.consume(&FSMInput::outputstreaminit),
      "write" => machine.consume(&FSMInput::write),
      "flush" => machine.consume(&FSMInput::flush),
      "close" => machine.consume(&FSMInput::close),
      "tobytearray" => machine.consume(&FSMInput::tobytearray),
      "tostring" => machine.consume(&FSMInput::tostring),
      _ => Err(()),
    };
  };
  println!("Final state {:?}", machine.state());
}

// TODO: initialize to current state, probably need to move away from simple
// FSM implementation
pub fn match_trace_substring(trace : Vec<String>, _init : String) -> String {
  let mut machine: StateMachine<FSM> = StateMachine::new();
  let _ = machine.consume(&FSMInput::outputstreaminit);
  for event in trace {
    let _result = match event.as_str() {
      "outputstreaminit" => machine.consume(&FSMInput::outputstreaminit),
      "write" => machine.consume(&FSMInput::write),
      "flush" => machine.consume(&FSMInput::flush),
      "close" => machine.consume(&FSMInput::close),
      "tobytearray" => machine.consume(&FSMInput::tobytearray),
      "tostring" => machine.consume(&FSMInput::tostring),
      _ => Err(()),
    };
  };
  return format!("{:?}", machine.state());
}
