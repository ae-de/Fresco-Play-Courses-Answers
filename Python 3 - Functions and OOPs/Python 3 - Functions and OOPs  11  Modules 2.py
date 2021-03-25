#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'usingiter' function below.
#
# The function is expected to return a TUPLE.
# The function accepts following parameters:
#  1. TUPLE tupb
#
import itertools
import operator


def performIterator(tuplevalues):
    l = []
    l1 = []
    n = 0
    for i in tuplevalues[0]:
        if n < 4:
            l1.append(i)
            n = n + 1
    l.append(tuple(l1))

    l2 = tuplevalues[1]
    x = l2[0]
    l2 = tuple(itertools.repeat(int(x), len(l2)))
    l.append(l2)

    l3 = tuple(itertools.accumulate(tuplevalues[2], operator.add))
    l.append(l3)

    l4 = tuple(itertools.chain(*tuplevalues))
    l.append(l4)

    l4 = tuple(itertools.filterfalse(lambda x: x % 2 == 0, l4))
    l.append(l4)

    return tuple(l)


if __name__ == '__main__':

    length = int(input().strip())

    qw1 = []
    for i in range(4):
        qw2 = []
        for _ in range(length):
            qw2_item = int(input().strip())
            qw2.append(qw2_item)
        qw1.append(tuple(qw2))
    tupb = tuple(qw1)

    q = performIterator(tupb)
    print(q)
