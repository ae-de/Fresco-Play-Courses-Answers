#!/bin/python3

import math
import os
import random
import re
import sys


class parent:
    def __init__(self, total_asset):
        self.total_asset = total_asset

    def display(self):
        print("Total Asset Worth is " + str(self.total_asset) + " Million.")
        print("Share of Parents is " + str(round(self.total_asset / 2, 2)) + " Million.")


# It is expected to create two child classes 'son' & 'daughter' for the above class 'parent'
#
# Write your code here

class son(parent):
    def __init__(self, total_asset, percentage_for_son, ):
        super().__init__(total_asset)
        self.percentage_for_son = percentage_for_son

    def son_display(self):
        share_son = (self.percentage_for_son * self.total_asset) / 100
        print("Share of Son is " + str(round(share_son, 2)) + " Million.")


class daughter(parent):
    def __init__(self, total_asset, percentage_for_daughter):
        super().__init__(total_asset)
        self.percentage_for_daughter = percentage_for_daughter

    def daughter_display(self):
        share_daughter = (self.percentage_for_daughter * self.total_asset) / 100
        print("Share of Daughter is " + str(round(share_daughter, 2)) + " Million.")


if __name__ == '__main__':
    t = int(input())
    sp = int(input())
    dp = int(input())

    obj1 = parent(t)

    obj2 = son(t, sp)
    obj2.son_display()
    obj2.display()

    obj3 = daughter(t, dp)
    obj3.daughter_display()
    obj3.display()

    print(isinstance(obj2, parent))
    print(isinstance(obj3, parent))

    print(isinstance(obj3, son))
    print(isinstance(obj2, daughter))
