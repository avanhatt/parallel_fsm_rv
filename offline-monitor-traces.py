import click
import os
import re
import sys
import subprocess

@click.command()
@click.argument('slices',
    type=click.Path(),
    default='slices',
    metavar='<out>')
def monitor(slices):
    for filename in os.listdir(slices):
        print("Checking trace:", filename)
        subprocess.run(["cargo", "run", "--", os.path.join(slices, filename)])

if __name__ == '__main__':
    monitor()