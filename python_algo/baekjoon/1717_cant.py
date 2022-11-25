# 백준 1717

import sys

n, m = map(int, sys.stdin.readline().split())

parent = [0] * (n + 1)

for i in range(1, n + 1):
    parent[i] = i

for i in range(m):
    t, a, b = map(int, sys.stdin.readline().split())
    if t == 0: # 합집합
        pass

    if t == 1: # 포함 여부
        pass