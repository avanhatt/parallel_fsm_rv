use rust_fsm::*;

// For now, example RV traffic light spec using Rust's FSM library
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


fn main() {
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
