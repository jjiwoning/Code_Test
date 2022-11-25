# 좌표 압축

import sys

n = int(sys.stdin.readline())

list1 = list(map(int, sys.stdin.readline().split()))

list2 = list(set(list1))
list2.sort()

dic = { }
for i in range(len(list2)):
    dic[list2[i]] = i

for i in range(len(list1)):
    list1[i] = dic.get(list1[i])

for i in range(len(list1)):
    print(list1[i], end = ' ')
