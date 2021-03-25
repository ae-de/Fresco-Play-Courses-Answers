#!/bin/python3

import math
import os
import random
import re
import sys


#
# Complete the 'Bank_ATM' function below.
#
# Define the Class for user-defined exceptions "MinimumDepositError" and "MinimumBalanceError" here
class MinimumDepositError(Exception):
    # Constructor method
    def __init__(self, value):
        self.value = value

    # __str__ display function
    def __str__(self):
        return repr(self.value)


class MinimumBalanceError(Exception):
    # Constructor method
    def __init__(self, value):
        self.value = value

    # __str__ display function
    def __str__(self):
        return repr(self.value)


def Bank_ATM(balance, choice, amount):
    isTrHappen = False

    try:
        if balance < 500:
            raise ValueError("As per the Minimum Balance Policy, Balance must be at least 500")

        if choice == 1:
            if amount < 2000:
                raise MinimumDepositError("The Minimum amount of Deposit should be 2000.")
            else:
                isTrHappen = True
                balance += amount
        else:
            balance -= amount
            if balance < 500:
                raise MinimumBalanceError("You cannot withdraw this amount due to Minimum Balance Policy")
            else:
                isTrHappen = True

    except ValueError as e:
        print(e)
    except MinimumDepositError as e:
        print(e.value)
    except MinimumBalanceError as e:
        print(e.value)

    if isTrHappen:
        print("Updated Balance Amount:  " + str(balance))


if __name__ == '__main__':

    bal = int(input())
    ch = int(input())
    amt = int(input())

    try:
        Bank_ATM(bal, ch, amt)


    except ValueError as e:
        print(e)
    except MinimumDepositError as e:
        print(e)
    except MinimumBalanceError as e:
        print(e)
