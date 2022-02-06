# 소트인사이드

import sys

n = sys.stdin.readline().strip()

numList = list(map(int, n))

numList.sort()
numList.reverse()
#numList.sort(reverse = True)


for i in numList:
    print(i, end = "")
