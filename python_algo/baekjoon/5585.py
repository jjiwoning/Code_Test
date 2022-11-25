# 거스름돈

import sys

n = int(sys.stdin.readline())

money = [500, 100, 50, 10, 5, 1]

n = 1000 - n
count = 0

for i in money:
    a = n//i
    n = n%i
    count = count + a

print(count)