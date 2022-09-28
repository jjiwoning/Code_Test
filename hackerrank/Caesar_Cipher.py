#!/bin/python3

import math
import os
import random
import re
import sys

#
# Complete the 'caesarCipher' function below.
#
# The function is expected to return a STRING.
# The function accepts following parameters:
#  1. STRING s
#  2. INTEGER k
#

def caesarCipher(s, k):
    # Write your code here
    alpha = "abcdefghijklmnopqrstuvwxyz"
    answer = ""
    for i in s:
        if i in alpha:
            idx = alpha.index(i) + k
            if idx >= len(alpha):
                while idx >= len(alpha):
                    idx = idx - len(alpha)
            answer += alpha[idx]
        elif i.isupper():
            m = i.lower()
            idx = alpha.index(m) + k
            if idx >= len(alpha):
                while idx >= len(alpha):
                    idx = idx - len(alpha)
            answer += alpha[idx].upper()
        else:
            answer += i
    
    return answer


if __name__ == '__main__':

    n = int(input().strip())

    s = input()

    k = int(input().strip())

    result = caesarCipher(s, k)

    print(result)