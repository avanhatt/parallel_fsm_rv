import click
import os
import re
import sys
import subprocess
import time
import csv

executable = "./target/release/parallel_fsm_rv"

def num_events(filename):
    with open(filename) as f:
        return len([0 for _ in f])

@click.command()
@click.argument('slices',
    type=click.Path(),
    default='slices',
    metavar='<out>')
@click.option('-p', '--par', type=int, default=2)
@click.option('-s', '--size', type=int)
@click.option('-n', type=int, default=1)
def monitor(slices, par, size, n):
    # Build the executable
    subprocess.check_call(["cargo", "build", "--release"])
    with open("output.csv", "w+") as f:
        writer = csv.writer(f)
        writer.writerow(["Parallel", "Time"])

        # Parse options
        for p in range(1, par + 1):
            flags = []
            if p == 1:
                flags += ["--seq"]
            else:
                flags += ["--par", str(p)]

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
            print("Par: {}\nTime: {}".format(p, elapsed_time))
            writer.writerow([p, elapsed_time])

if __name__ == '__main__':
    monitor()