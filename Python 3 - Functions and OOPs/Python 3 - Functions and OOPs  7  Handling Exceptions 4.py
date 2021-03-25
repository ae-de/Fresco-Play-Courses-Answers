#!/bin/python3

import math
import os
import random
import re
import sys


#
# Complete the 'Library' function below.
#


def Library(memberfee, installment, book):
    listOfBooks = ['Philosophers Stone', 'Chamber of Secrets', 'Prisoner of Azkaban', 'Goblet of Fire', 'Order of Phoenix', 'Half Blood Prince', 'Deathly Hallows 1', 'Deathly Hallows 2']
    try:
        if installment > 3:
            raise ValueError("Maximum Permitted Number of Installments is 3")
        elif installment == 0:
            raise ZeroDivisionError("Number of Installments cannot be Zero.")
        else:
            print("Amount per Installment is  " + str(float(memberfee / installment)))

        if book.lower() in (string.lower() for string in listOfBooks):
            print("It is available in this section")
        else:
            raise NameError("No such book exists in this section")

    except ValueError as e:
        print(e)
    except ZeroDivisionError as e:
        print(e)
    except NameError as e:
        print(e)

if __name__ == '__main__':

    memberfee = int(input())
    installment = int(input())
    book = input()

    try:
        Library(memberfee, installment, book)

    except ZeroDivisionError as e:
        print(e)
    except ValueError as e:
        print(e)
    except NameError as e:
        print(e)