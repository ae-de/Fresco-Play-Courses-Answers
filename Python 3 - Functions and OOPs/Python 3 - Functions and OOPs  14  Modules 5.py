#!/bin/python3

import math
import os
import random
import re
import sys
import collections


#
# Complete the 'collectionfunc' function below.
#
# The function accepts following parameters:
#  1. STRING text1
#  2. DICTIONARY dictionary1
#  3. LIST key1
#  4. LIST val1
#  5. DICTIONARY deduct
#  6. LIST list1
#

def collectionfunc(text1, dictionary1, key1, val1, deduct, list1):
    # Section 1
    dict_count = dict()
    text_split = text1.split()
    for word in sorted(text_split):
        if word not in dict_count:
            dict_count[word] = 0
        dict_count[word] += 1
    print(dict_count)

    # Section 2
    cnt = Counter(dictionary1)
    cnt.subtract(deduct)
    print(dict(cnt))

    # Section 3
    od = collections.OrderedDict(zip(key1, val1))
    od.pop(key1[1])

    # Section 4
    od[key1[1]] = val1[1]
    print(dict(od))

    # Section 5
    count = collections.defaultdict(int)
    count_even = []
    count_odd = []
    for items in list1:
        if items % 2 == 0:
            count_even.append(items)
        else:
            count_odd.append(items)
    if count_odd:
        count['odd'] = count_odd
    if count_even:
        count['even'] = count_even
    print(dict(count))


if __name__ == '__main__':
    from collections import Counter

    text1 = input()

    n1 = int(input().strip())
    qw1 = []
    qw2 = []
    for _ in range(n1):
        qw1_item = (input().strip())
        qw1.append(qw1_item)
        qw2_item = int(input().strip())
        qw2.append(qw2_item)
    testdict = {}
    for i in range(n1):
        testdict[qw1[i]] = qw2[i]
    collection1 = (testdict)

    qw1 = []
    n2 = int(input().strip())
    for _ in range(n2):
        qw1_item = (input().strip())
        qw1.append(qw1_item)
    key1 = qw1

    qw1 = []
    n3 = int(input().strip())
    for _ in range(n3):
        qw1_item = int(input().strip())
        qw1.append(qw1_item)
    val1 = qw1

    n4 = int(input().strip())
    qw1 = []
    qw2 = []
    for _ in range(n4):
        qw1_item = (input().strip())
        qw1.append(qw1_item)
        qw2_item = int(input().strip())
        qw2.append(qw2_item)
    testdict = {}
    for i in range(n4):
        testdict[qw1[i]] = qw2[i]
    deduct = testdict

    qw1 = []
    n5 = int(input().strip())
    for _ in range(n5):
        qw1_item = int(input().strip())
        qw1.append(qw1_item)
    list1 = qw1

    collectionfunc(text1, collection1, key1, val1, deduct, list1)
