# 수들의 합

import sys

s = int(sys.stdin.readline())

n = 1

sumN = int(n*(n + 1) // 2)

while sumN < s:
    n += 1
    sumN = int(n*(n + 1) // 2)

print(n - 1)