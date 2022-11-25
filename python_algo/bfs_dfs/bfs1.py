from collections import deque
import sys

s, e = map(int, sys.stdin.readline().split())

jump = [0] * 10001

def bfs(level):
    q = deque()
    q.append(level)

    while q:
        now = q.popleft()
        for i in (5, 1, -1):
            
            if now + i < 1 or now + i > 10001:
                continue

            if now == e:
                return jump[e]

            if jump[now + i] == 0:
                jump[now + i] = jump[now] + 1
                q.append(now + i)
            
    return jump[e]

print(bfs(s))
