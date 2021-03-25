#!/bin/python3

import math
import os
import random
import re
import sys


def Reverse(lst):
    lst.reverse()
    return lst


def stringmethod(para, special1, special2, list1, strfind):
    # Section 1 --> Ok
    word1 = ""
    for character in para:
        if character not in special1:
            word1 = word1 + character
    rword2 = word1[0:70]
    print(rword2[::-1])

    # Section 2 --> Ok
    rword3 = rword2[::-1]
    rword3 = re.sub("\s+", "", rword3)
    temp = ""
    for character in rword3:
        temp = temp + character + special2
    print(temp[:-1])

    # Section 3 --> Ok
    a = True
    for s in list1:
        if s not in para:
            a = False
    if a:
        print("Every string in ", end=" "),
        print(list1, end=" "),
        print("were present")
    else:
        print("Every string in ", end=" "),
        print(list1, end=" "),
        print("were not present")

    # Section 4 --> OK
    print(word1.split()[:20])

    # Section 5
    word_list = word1.split()

    temp_dict = dict()
    for str1 in word_list:
        if word_list.count(str1) <= 3:
            if str1 not in temp_dict:
                temp_dict[str1] = 0
            temp_dict[str1] += 1
    temp_list = []
    for value in list(reversed(list(temp_dict)))[0:20]:
        temp_list.append(value)
    print(Reverse(temp_list))

    # Section 6
    print(word1.rindex(strfind))


if __name__ == '__main__':
    para = input()  # a string
    spch1 = input()
    spch2 = input()
    qw1_count = int(input().strip())
    qw1 = []
    for _ in range(qw1_count):
        qw1_item = input()
        qw1.append(qw1_item)
    strf = input()
    stringmethod(para, spch1, spch2, qw1, strf)
