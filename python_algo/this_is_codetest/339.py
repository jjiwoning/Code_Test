from collections import deque
import sys

n, m, k, x = map(int, sys.stdin.readline().split())

ls = [[] for _ in range(n + 1)] 

visited = [0] * (n + 1)

for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    ls[a].append(b)

q = deque()
q.append(x)
visited[x] = 1
while q:
    a = q.popleft()
    for i in ls[a]:
        if visited[i] == 0:
            visited[i] = visited[a] + 1
            q.append(i)

if k + 1 not in visited:
    print(-1)
    sys.exit(0)

for i in range(1, len(visited)):
    if visited[i] - 1 == k:
        print(i)