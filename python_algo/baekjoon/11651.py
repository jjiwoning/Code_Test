# 좌표 정렬하기 2

import sys

n = int(sys.stdin.readline())
xyList = []

for _ in range(n):
    xyList.append(list(map(int, sys.stdin.readline().split())))

# key를 사용해서 정렬
xyList.sort( key = lambda x : (x[1], x[0]))

for i in range(len(xyList)):
    print(xyList[i][0] , xyList[i][1])