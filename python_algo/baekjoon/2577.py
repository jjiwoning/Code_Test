import sys

a = int(sys.stdin.readline())
b = int(sys.stdin.readline())
c = int(sys.stdin.readline())

mul = a * b * c
mul = str(mul)

arr = [0] * 10

for i in mul:
    arr[int(i)] += 1

for i in arr:
    print(i)