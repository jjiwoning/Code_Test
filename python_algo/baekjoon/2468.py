import sys

sys.setrecursionlimit(100000)

n = int(sys.stdin.readline())

graph = []
maxNum = 0

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def dfs(x, y, h):
    for i in range(4):
        mx = x + dx[i]
        my = y + dy[i]
        if 0 <= mx < n and 0 <= my < n and checked[mx][my] == False and graph[mx][my] > h:
            checked[mx][my] = True
            dfs(mx, my, h)

for i in range(n):
    graph.append(list(map(int, sys.stdin.readline().split())))
    for j in range(n):
        if graph[i][j] > maxNum:
            maxNum = graph[i][j]

answer = 0

for i in range(maxNum):
    cnt = 0
    checked = [[False] * n for _ in range(n)]
    for j in range(n):
        for k in range(n):
            if checked[j][k] == False and graph[j][k] > i:
                cnt += 1
                checked[j][k] = True
                dfs(j, k, i)
    answer = max(answer, cnt)

print(answer)