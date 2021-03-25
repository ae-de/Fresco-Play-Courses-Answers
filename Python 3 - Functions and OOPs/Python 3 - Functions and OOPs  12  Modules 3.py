#!/bin/python3

import math
import os
import random
import re
import sys
from cryptography.fernet import Fernet


#
# Complete the 'encrdecr' function below.
#
# The function is expected to return a LIST.
# The function accepts following parameters:
#  1. STRING keyval --> used to encrypt and decrypt data
#  2. STRING textencr --> text to be encrypted
#  3. Byte-code textdecr --> byte-code to be decrypted
#

# Function Start
def encrdecr(keyval, textencr, textdecr):
    main_list = []
    cipher_suite = Fernet(keyval)
    cipher_text = cipher_suite.encrypt(textencr)
    main_list.append(cipher_text)
    plain_text = cipher_suite.decrypt(textdecr)
    main_list.append(plain_text.decode("ascii"))
    return main_list
# FUnction End

if __name__ == '__main__':

    keyval = Fernet.generate_key()

    textencr = str(input()).encode()

    textdecr = str(input()).encode()

    result = encrdecr(keyval, textencr, textdecr)
    print(result)
