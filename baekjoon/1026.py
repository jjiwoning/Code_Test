# 보물

import sys

n = int(sys.stdin.readline())

a = list(map(int, sys.stdin.readline().split()))
b = list(map(int, sys.stdin.readline().split()))

a1 = sorted(a)
b1 = sorted(b, reverse = True)

sum = 0

for i in range(n):
    sum += a1[i]*b1[i]

print(sum)