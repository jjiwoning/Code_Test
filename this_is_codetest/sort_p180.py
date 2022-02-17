# 성적이 낮은 순서로 학생 출력하기

import sys

n = int(sys.stdin.readline())

array = []

for i in range(n):
    inputArr = list(map(str, sys.stdin.readline().split()))
    array.append([inputArr[0], int(inputArr[1])])

array.sort(key = lambda x: x[1])

for i in range(len(array)):
    print(array[i][0], end = '')
    