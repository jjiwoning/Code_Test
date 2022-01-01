# 백준 1920번 문제

import sys

def BinarySearch(a, b):
    start = 0
    last = len(a) - 1
    while start <= last:
        mid = (start + last)// 2
        if a[mid] == b:
            return 1
        elif a[mid] > b:
            last = mid - 1
        elif a[mid] < b:
            start = mid + 1
    return 0

n = int(sys.stdin.readline())

a = [None] * n
a = list(map(int,sys.stdin.readline().split()))
a.sort()

m = int(sys.stdin.readline())

b = [None] * m
b = list(map(int,sys.stdin.readline().split()))

for i in range(len(b)):
    print(BinarySearch(a, b[i]))

