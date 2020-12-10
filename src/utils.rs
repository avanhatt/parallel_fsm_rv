use std::fs::File;
use std::io::{self};

#[cfg(target_arch = "x86_64")]
use core::arch::x86_64::*;

// States and events both encoded as i8
pub type State = i8;
pub type Event = i8;

pub const SET_ZERO : State = i8::MIN;

// Largest shuffle supported
pub const SHUF_SIZE : usize = 16;

// Identity function
pub fn iden() -> __m128i {
  to_m128i([0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 14, 14, 15].to_vec())
}

// Takes indices in the intuitive order, so needs to do some conversions to
// match Intel's shuffle semantics
pub fn to_m128i(values : Vec<i8>) -> __m128i {
  assert!(values.len() <= SHUF_SIZE, "Can shuffle up to {} bytes", SHUF_SIZE);

  let mut resized = values.to_vec();
  resized.resize(SHUF_SIZE, 0);

  // Shuffle
  unsafe {
    _mm_set_epi8(
      resized[15],
      resized[14],
      resized[13],
      resized[12],
      resized[11],
      resized[10],
      resized[9],
      resized[8],
      resized[7],
      resized[6],
      resized[5],
      resized[4],
      resized[3],
      resized[2],
      resized[1],
      resized[0],
    )
  }
}

pub fn store_to_vec(values : __m128i) -> [i8; SHUF_SIZE] {
  unsafe {
    let mut vec : [i8; 16] = [0; SHUF_SIZE];
    _mm_storeu_si128(
      vec.as_mut_ptr() as *mut _,
      values,
    );
    vec
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