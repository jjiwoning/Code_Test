# 제로

import sys

k = int(sys.stdin.readline())
numList = []

for i in range(k):
    a = int(sys.stdin.readline())
    if a == 0:
        numList.pop()
    else:
        numList.append(a)

print(sum(numList))