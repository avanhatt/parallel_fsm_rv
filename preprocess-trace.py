import click
from collections import defaultdict
import os
import re
import sys

@click.command()
@click.argument('out',
    type=click.Path(),
    default='slices',
    metavar='<out>')
@click.option('--dedup/--no-dedup', default=True)
def preprocess(out, dedup):
    """Preprocess trace by removing tags, splitting on monitor instance, and
    writing to a new file per monitor instance.
    """
    slicing = defaultdict(list)
    for line in sys.stdin.readlines():
        line = line.replace("AVH:", "")
        [event, instance, _] = re.split('(\d.*)', line)
        slicing[instance].append(event)

    # Output dir
    if not os.path.exists(out):
        os.makedirs(out)

    seen_traces = set()
    for instance, events in slicing.items():
        if dedup and "{}".format(events) in seen_traces:
            print("Skipping duplicate trace:", instance)
            continue
        seen_traces.add("{}".format(events))
        slice_path = os.path.join(out, instance)
        with open(slice_path, "w") as file:
            for event in events:
                file.write("{}\n".format(event))

if __name__ == '__main__':
    preprocess()