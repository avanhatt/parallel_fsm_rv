import click
import os
import re
import sys
import subprocess
import time

executable = "./target/release/parallel_fsm_rv"


def num_events(filename):
    with open(filename) as f:
        return len([0 for _ in f])

@click.command()
@click.argument('slices',
    type=click.Path(),
    default='slices',
    metavar='<out>')
@click.option('-p', '--par', type=str)
@click.option('-s', '--size', type=int)
@click.option('-n', type=int, default=1)
def monitor(slices, par, size, n):
    # Build the executable
    subprocess.check_call(["cargo", "build", "--release"])

    # Parse options
    flags = []
    if par:
        if int(par) == 1:
            flags += ["--seq"]
        else:
            flags += ["--par", par]

    start_time = time.time()
    for filename in os.listdir(slices):
        if size:
            if num_events(os.path.join(slices, filename)) < size:
                continue
        print("Checking trace:", filename)
        for _ in range(n):
            subprocess.run([executable, os.path.join(slices, filename)] + flags)
    end_time = time.time()
    elapsed_time = end_time - start_time
    print("Time: ", elapsed_time)



if __name__ == '__main__':
    monitor()