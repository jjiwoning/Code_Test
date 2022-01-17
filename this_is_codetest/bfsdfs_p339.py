# 특정 거리의 도시 찾기
import sys
from collections import deque

def bfs(graph, k, x, visited):
    queue = deque([x])
    visited[x] = 1
    while queue:
        v = queue.popleft()
        for i in graph[v]:
            if visited[i] == 0:
                queue.append(i)
                visited[i] = visited[v] + 1
    check = False
    for j in range(len(visited)):
        if visited[j] == (k+1):
            print(j)
            check = True
    if check == False:
        print(-1)

n, m, k, x = map(int, sys.stdin.readline().split())
graph = [[]for _ in range(n + 1)]
visited = [0] * (n+1)
for i in range(m):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

bfs(graph, k, x, visited)