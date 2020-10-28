import click
from collections import defaultdict
import re
import sys

def preprocess():
    slicing = defaultdict(list)
    for line in sys.stdin.readlines():
        line = line.replace("AVH:", "")
        [event, instance, _] = re.split('(\d.*)', line)
        slicing[instance].append(event)
    seen_traces = set()
    for instance, events in slicing.items():
        if "{}".format(events) in seen_traces:
            print("Skipping duplicate trace")
            continue
        seen_traces.add("{}".format(events))
        with open("slice_{}".format(instance), "w") as file:
            for event in events:
                file.write("{}\n".format(event))

if __name__ == '__main__':
    preprocess()