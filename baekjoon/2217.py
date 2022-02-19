# 로프

import sys

n = int(sys.stdin.readline())
arr = []

for i in range(n):
    arr.append(int(sys.stdin.readline()))

arr.sort(reverse = True)
newArr = []

for i in range(len(arr)):
    newArr.append(arr[i]*(i+1))

print(max(newArr))