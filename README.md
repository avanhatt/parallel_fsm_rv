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

[rv]: https://courses.cs.cornell.edu/courses/cs6156/2020fa/
[dfsms]: https://dl.acm.org/doi/10.1145/2541940.2541988
[rust]: https://www.rust-lang.org/learn/get-started
[python3]: https://www.python.org/download/releases/3.0/