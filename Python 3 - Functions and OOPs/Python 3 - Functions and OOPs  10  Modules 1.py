#!/bin/python3

import math
import os
import random
import re
import sys
import datetime
from datetime import datetime as dt
#
# Complete the 'dateandtime' function below.
#
# The function accepts INTEGER val as parameter.
# The return type must be LIST.
#


def dateandtime(val, tup):
    list1 = []
    if val == 1:
        date = datetime.datetime(tup[0], tup[1], tup[2]).date()
        list1.append(date)
        list1.append(date.strftime("%d/%m/%Y"))
    elif val == 2:
        list1.append(dt.fromtimestamp(tup[0]).date())
    elif val == 3:
        str_format = str(tup[0]) + ":" + str(tup[1]) + ":" + str(tup[2])
        time_format = dt.strptime(str_format, "%H:%M:%S")
        list1.append(time_format.time())
        list1.append(str(time_format.strftime("%I")))
    elif val == 4:
        date = datetime.datetime(tup[0], tup[1], tup[2])
        list1.append(date.strftime("%A"))
        list1.append(date.strftime("%B"))
        list1.append(date.strftime("%j"))
    elif val == 5:
        list1.append(datetime.datetime(tup[0], tup[1], tup[2], tup[3], tup[4], tup[5]))
    return list1

if __name__ == '__main__':
    val = int(input().strip())

    if val == 1 or val == 4 or val == 3:
        qw1_count = 3
    if val == 2:
        qw1_count = 1
    if val == 5:
        qw1_count = 6
    qw1 = []

    for _ in range(qw1_count):
        qw1_item = int(input().strip())
        qw1.append(qw1_item)

    tup = tuple(qw1)

    ans = dateandtime(val, tup)

    print(ans)