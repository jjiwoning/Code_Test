# 백준 블랙잭

from itertools import combinations
import sys

n, m = map(int, sys.stdin.readline().split())
numList = list(map(int, sys.stdin.readline().split()))

num3 = list(combinations(numList, 3))

numSum = []
for i in range(len(num3)):
    a = sum(num3[i])
    numSum.append(a)

min = 3000000
for i in numSum:
    if (m - i) <= min and (m - i) >= 0:
        min = m - i
        findNum = i

print(findNum)