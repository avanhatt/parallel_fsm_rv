use rust_fsm::*;

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
