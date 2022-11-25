# 백준 1783 병든 나이트

from collections import deque
import sys

def solution(x, y):
    if y == 1:
        return 1
    elif y == 2:
        return min(4, (x + 1) // 2)
    else:
        if x <= 6:
            return min(4, x)
        else:
            return (x - 2)

y, x = map(int, sys.stdin.readline().split())

print(solution(x, y))

