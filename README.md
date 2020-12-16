# Exploring Data Parallel Finite State Machines for Runtime Verification
---

A course project for [CS 6156: Runtime Verification][rv].

The goal is to exploit the parallelism offered by modern hardware to lower
the runtime and energy overhead of monitoring with finite state machines, based
initially on techniques from the ASPLOS 2014 paper [Data-parallel Finite State
Machines][dfsms].

---
## How to install

Install [Rust][] and run `cargo test` in the root of this repository to install
all monitor dependencies. Install [Python3][] and run `pip3 install click` to install
scripting dependencies.

## How to use

This project provides a tool with a command line interface:
```
Parallel FSM for Runtime Verification

USAGE:
    parallel_fsm_rv [FLAGS] [OPTIONS] <INPUT>

FLAGS:
    -h, --help       Prints help information
        --seq        Run sequentially
    -V, --version    Prints version information

OPTIONS:
        --par <par>    Parallelism factor (number of cores), defaults to
                       number of physical cores on the machine

ARGS:
    <INPUT>    Sets the input file
```

To run the project on a well-formatted trace:
```
cargo run --release compress-slices/52654653
```

### Obtaining traces

Use JavaMOP to obtain a raw trace, then pipe it to the preprocessing script:
```
cat trace | python3 preprocess-trace.py
```

This script has the following options:
```
Usage: preprocess-trace.py [OPTIONS] <out>

  Preprocess trace by removing tags, splitting on monitor instance, and
  writing to a new file per monitor instance.

Options:
  --dedup / --no-dedup
  --help                Show this message and exit.
```

[rv]: https://courses.cs.cornell.edu/courses/cs6156/2020fa/
[dfsms]: https://dl.acm.org/doi/10.1145/2541940.2541988
[rust]: https://www.rust-lang.org/learn/get-started
[python3]: https://www.python.org/download/releases/3.0/