import sys

n = int(sys.stdin.readline())
ls = [[] for _ in range(n + 1)]
visited = [0] * (n + 1)

a, b = map(int, sys.stdin.readline().split())

k = int(sys.stdin.readline())

for i in range(k):
    l, m = map(int, sys.stdin.readline().split())
    ls[l].append(m)
    ls[m].append(l)

def dfs(a):
    for i in ls[a]:
        if visited[i] == 0:
            visited[i] = visited[a] + 1
            dfs(i)

dfs(a)

print(visited[b] if visited[b] > 0 else -1)




