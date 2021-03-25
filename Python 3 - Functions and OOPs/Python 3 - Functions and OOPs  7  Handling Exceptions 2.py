#!/bin/python3

import math
import os
import random
import re
import sys


#
# Complete the 'FORLoop' function below.
#

def FORLoop():
    n = int(input())
    l1 = []

    for i in range(0, n):
        l1.append(int(input()))

    print(l1)

    iter1 = iter(l1)

    while True:
        try:
            # Iterate by calling next
            print(next(iter1))
        except StopIteration:
            # exception will happen when iteration will over
            break

    return iter1


if __name__ == '__main__':
    try:
        d = FORLoop()
        print(type(d))
        print(next(d))

    except StopIteration:
        print('Stop Iteration : No Next Element to fetch')
