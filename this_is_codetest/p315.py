# 볼링공 고르기

import sys

n, m = map(int, sys.stdin.readline().split())
ball = list(map(int, sys.stdin.readline().split()))
answer = 0

for i in range(n - 1):
    for j in range(i + 1, n):
        if ball[i] != ball[j]:
            answer += 1

print(answer)
