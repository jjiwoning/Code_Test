# 수 정렬하기

import sys

n = int(sys.stdin.readline())
numList = []
for i in range(n):
    num = int(sys.stdin.readline())
    numList.append(num)

numList.sort()

for i in range(n):
    print(numList[i])