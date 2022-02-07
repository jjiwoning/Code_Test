# 단어 정렬

import sys

n = int(sys.stdin.readline())
strList = []

for i in range(n):
    strList.append(sys.stdin.readline().strip())

strList = list(set(strList))

strList.sort( key = lambda x : (len(x), x))

for i in range(len(strList)):
    print(strList[i])