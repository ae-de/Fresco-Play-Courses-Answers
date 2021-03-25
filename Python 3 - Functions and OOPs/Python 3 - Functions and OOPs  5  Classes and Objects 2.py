#!/bin/python3

import math
import os
import random
import re
import sys

# Write your code here
class comp:
    def __init__(self, real, imaginary):
        self.real = real
        self.imaginary = imaginary

    def add(self, obj):
        re = self.real + obj.real
        im = self.imaginary + obj.imaginary
        print("Sum of the two Complex numbers :"+str(re)+"+"+str(im)+"i")

    def sub(self, obj):
        re1 = self.real - obj.real
        im1 = self.imaginary - obj.imaginary
        if im1 >= 0:
            print("Subtraction of the two Complex numbers :"+str(re1)+"+"+str(im1)+"i")
        else:
            print("Subtraction of the two Complex numbers :" + str(re1) + str(im1) + "i")

if __name__ == '__main__':
    real1 = int(input().strip())
    img1 = int(input().strip())

    real2 = int(input().strip())
    img2 = int(input().strip())

    p1 = comp(real1, img1)
    p2 = comp(real2, img2)

    p1.add(p2)
    p1.sub(p2)
