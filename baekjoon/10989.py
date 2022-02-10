# 수 정렬하기 3

# 계수 정렬을 이용해서 푼다.

import sys

n = int(sys.stdin.readline())
count = [0] * 10001

for i in range(n):
    count[int(sys.stdin.readline())] += 1

for i in range(len(count)):
    for j in range(count[i]):
        print(i)
