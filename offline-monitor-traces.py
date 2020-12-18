import click
import os
import re
import sys
import subprocess

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
def monitor(slices, par, size):
    # Build the executable
    subprocess.check_call(["cargo", "build"])

    # Parse options
    flags = []
    if par:
        if int(par) == 1:
            flags += ["--seq"]
        else:
            flags += ["--par", par]

    for filename in os.listdir(slices):
        if size:
            if num_events(os.path.join(slices, filename)) < size:
                continue
        print("Checking trace:", filename)
        subprocess.run([executable, os.path.join(slices, filename)] + flags)

if __name__ == '__main__':
    monitor()