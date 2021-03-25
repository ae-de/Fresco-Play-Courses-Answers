#!/bin/python3

import math
import os
import random
import re
import sys
import calendar
import datetime
from collections import Counter
#
# Complete the 'usingcalendar' function below.
#
# The function accepts TUPLE datetuple as parameter.
#


def most_frequent(List):
    occurence_count = Counter(List)
    return occurence_count.most_common(1)[0][0]


def usingcalendar(datetuple):
    month = datetuple[1]
    if calendar.isleap(datetuple[0]):
        month = 2
    print(calendar.month(datetuple[0], month))

    obj = calendar.Calendar()
    day_list = []
    for day in obj.itermonthdates(datetuple[0], month):
        day_list.append(day)
    print(day_list[-7:])

    day_name_list = []
    for day in day_list:
        if day.month == month:
            day_name_list.append(day.strftime("%A"))
    print(most_frequent(day_name_list))


if __name__ == '__main__':
    qw1 = []

    for _ in range(3):
        qw1_item = int(input().strip())
        qw1.append(qw1_item)

    tup = tuple(qw1)

    usingcalendar(tup)
