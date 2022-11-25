# 바이러스

import sys

n = int(sys.stdin.readline())

list = [ [] for _ in range(n+1) ]

a = int(sys.stdin.readline())

for i in range(a):
    x, y = map(int, sys.stdin.readline().split())
    list[x].append(y)
    list[y].append(x)

def dfs(list, v, visited, cnt):
    visited[v] = True
    cnt.append(v)
    for i in list[v]:
        if not visited[i]:
            dfs(list, i, visited, cnt)
    return cnt
    

visited = [False] * (n+1)
cnt = []

a = dfs(list, 1, visited, cnt)

if a == []:
    print(0)
else:
    print(len(a) - 1)


