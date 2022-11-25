# 좌표 정렬하기

import sys

n = int(sys.stdin.readline())
xyList = []

for _ in range(n):
    xyList.append(list(map(int, sys.stdin.readline().split())))

xyList.sort()

for i in range(len(xyList)):
    print(xyList[i][0] , xyList[i][1])