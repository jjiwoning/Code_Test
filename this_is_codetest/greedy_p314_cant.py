# 만들 수 없는 금액

import sys

n = int(sys.stdin.readline())
money = list(map(int, sys.stdin.readline().split()))

money.sort()

target = 1

for i in money:
    if target < i:
        break
    target += i

print(target)
