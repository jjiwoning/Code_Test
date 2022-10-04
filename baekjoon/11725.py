import sys

sys.setrecursionlimit(10000000)

n = int(sys.stdin.readline())

visited = [0] * (n + 1)

graph = [[] for _ in range(n + 1)]

for i in range(n - 1):
    a, b = map(int, sys.stdin.readline().split())
    graph[a].append(b)
    graph[b].append(a)

def dfs(now):
    for i in graph[now]:
        if visited[i] == 0:
            visited[i] = now
            dfs(i)

dfs(1)

for i in range(2, len(visited)):
    print(visited[i])