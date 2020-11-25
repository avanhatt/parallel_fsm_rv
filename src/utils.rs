use std::fs::File;
use std::io::{self};

pub fn to_trace(lines : io::Lines<io::BufReader<File>>) -> Vec<String> {
    return lines.map(|l| l.expect("Failed to parse line"))
                .collect();
}