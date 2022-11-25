# 백준 1260 bfs,dfs

import sys
from collections import deque

def bfs(graph, v, visited):
    queue = deque([v])
    visited[v] = True
    while queue:
        v = queue.popleft()
        print(v, end = ' ')
        for i in graph[v]:
            if not visited[i]:
                queue.append(i)
                visited[i] = True


def dfs(graph, v, visited):
    visited[v] = True
    print(v, end = ' ')
    for i in graph[v]:
        if not visited[i]:
            dfs(graph, i, visited)



n, m, v = map(int, sys.stdin.readline().split())
graph = [[]for i in range(n + 1)]
for i in range(m):
    # a, b 를 입력 받은 후 그래프에 인접 노드로 넣어줌
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)
# 탐색을 위해 그래프 정렬해줌
for i in range(1, n+1):
    graph[i].sort()

visited = [False]*(n+1)
dfs(graph, v, visited)
print()
visited = [False]*(n+1)
bfs(graph, v, visited)