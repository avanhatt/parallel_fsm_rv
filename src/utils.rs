use std::fs::File;
use std::io::{self};
use std::convert::TryInto;

#[cfg(target_arch = "x86_64")]
use core::arch::x86_64::*;

// States eand events both encoded as an i8
pub type State = i8;
pub type Event = i8;

pub const SET_ZERO : State = i8::MIN;

// Largest shuffle supported
pub const SHUF_SIZE : usize = 16;

// Identity function
pub fn iden() -> __m128i {
  unsafe {
    _mm_set_epi8(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 14, 15)
  }
}

// Takes indices in the intuitive order, so needs to do some conversions to
// match Intel's shuffle semantics
pub fn shuffle_mask(indices : Vec<i8>) -> __m128i {
  assert!(indices.len() <= SHUF_SIZE, "Can shuffle up to {} bytes", SHUF_SIZE);
  let offset : i8 = (SHUF_SIZE - 1).try_into().unwrap();
  let mut shuffle : Vec<i8> = indices.into_iter().map(|x| offset - x).collect();

  // Fill with highest bit set so output will be 0's
  shuffle.resize(SHUF_SIZE, SET_ZERO);

  // Shuffle
  unsafe {
    _mm_set_epi8(
      shuffle[15],
      shuffle[14],
      shuffle[13],
      shuffle[12],
      shuffle[11],
      shuffle[10],
      shuffle[9],
      shuffle[8],
      shuffle[7],
      shuffle[6],
      shuffle[5],
      shuffle[4],
      shuffle[3],
      shuffle[2],
      shuffle[1],
      shuffle[0],
    )
  }
}

pub fn gather(before : __m128i, indices: __m128i) -> __m128i {
  unsafe {
     _mm_shuffle_epi8(before, indices)
  }
}

// Convert lines of a file to a vec of Strings
pub fn to_trace(lines : io::Lines<io::BufReader<File>>) -> Vec<String> {
  return lines.map(|l| l.expect("Failed to parse line"))
              .collect();
}