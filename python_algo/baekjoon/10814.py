# 나이 순 정렬

import sys

n = int(sys.stdin.readline())
list = []

for i in range(n):
    a ,b = map(str, sys.stdin.readline().split())
    list.append([int(a), b])

list = sorted(list, key = lambda x : x[0])

for i in range(len(list)):
    print(list[i][0], list[i][1])