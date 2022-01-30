# 분해합

import sys

num = int(sys.stdin.readline())

for i in range(1, num + 1):
    sumI = sum(map(int, str(i)))
    realSum = i + sumI
    if realSum == num:
        print(i)
        break
    if i == num:
        print(0)
        break