import math
import os
import random
import re
import sys


def minimumBribes(q):
    # Write your code here
    for i in range(len(q)):
        if q[i] > i + 3:
            print("Too chaotic")
            return

    cnt = 0

    for i in range(len(q)):
        if q[i] > i + 1:
            for j in range(i + 1, len(q)):
                q[i], q[j] = q[j], q[i]
                cnt += 1
                if q[i] == i + 1:
                    break

    print(cnt)


if __name__ == '__main__':
    t = int(input().strip())

    for t_itr in range(t):
        n = int(input().strip())

        q = list(map(int, input().rstrip().split()))

        minimumBribes(q)