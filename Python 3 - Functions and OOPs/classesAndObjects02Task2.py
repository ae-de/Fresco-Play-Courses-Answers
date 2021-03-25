#!/bin/python3

import math
import os
import random
import re
import sys


# Write your code here
class rectangle:
    def display(self):
        print("This is a Rectangle")

    def area(self, length, breadth):
        area = length * breadth
        print("Area of Rectangle is  " + str(area))


class square:
    def display(self):
        print("This is a Square")

    def area(self, side):
        area = side * side
        print("Area of square is  " + str(area))


if __name__ == '__main__':
    l = int(input())
    b = int(input())
    s = int(input())

    obj1 = rectangle()
    obj1.display()
    obj1.area(l, b)

    obj2 = square()
    obj2.display()
    obj2.area(s)
