from collections import deque
import sys

f, s, g, u, d = map(int, sys.stdin.readline().split())

count = [0] * (f + 1)
visited = [False] * (f + 1)

def bfs(start):
    queue = deque()
    queue.append(start)
    visited[start] = True

    while queue:
        now = queue.popleft()
        for i in (u, -d):
            if 1 <= now + i <= f and not visited[now + i] :
                queue.append(now + i)
                visited[now + i] = True
                count[now + i] = count[now] + 1
                
bfs(s)

if visited[g] == 0:
    print("use the stairs")
else:
    print(count[g])