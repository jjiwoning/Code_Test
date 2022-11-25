# 프린터 큐

import sys

n = int(sys.stdin.readline())

for i in range(n):
    a, b = map(int, sys.stdin.readline().split())
    queue = list(map(int, sys.stdin.readline().split()))
    index = list(range(a))

    
