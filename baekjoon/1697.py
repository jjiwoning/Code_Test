from collections import deque
import sys

n, k = map(int, sys.stdin.readline().split())

answer = k - n
ls = [0] * 100001

def bfs(n, k):
    queue = deque()
    queue.append(n)
    while queue:
        x = queue.popleft()
        if x == k:
            return ls[x]
        
        for i in (x + 1, x - 1, x * 2):
            if 0 <= i <= 100000 and not ls[i]:
                ls[i] = ls[x] + 1
                queue.append(i)

print(bfs(n, k))