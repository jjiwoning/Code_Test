import sys

sys.setrecursionlimit(100000000)

n, m = map(int, sys.stdin.readline().split())

graph = []

maxVal = 0

for i in range(n):
    graph.append(list(map(int, sys.stdin.readline().split())))
    for j in range(m):
        if graph[i][j] > maxVal:
            maxVal = graph[i][j]

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def dfs(x, y):
    for i in range(4):
        mx = x + dx[i]
        my = y + dy[i]
        if 0 <= mx < n and 0 <= my < m:
            if graph[mx][my] != 0:
                checked[mx][my] = True
                dfs(mx, my)
            elif graph[mx][my] == 0:
                count[x][y] += 1

answer = 0
check = False

while True:
    cnt = 0
    checked = [[False] * m for _ in range(n)]
    count = [[0] * m for _ in range(n)]
    for j in range(n):
        for k in range(m):
            if graph[j][k] > 0 and not checked[j][k]:
                checked[j][k] = True
                dfs(j, k)
                cnt += 1
    
    for i in range(n):
        for j in range(m):
            graph[i][j] -= count[i][j]
            if graph[i][j] < 0:
                graph[i][j] = 0

    if cnt >= 2:
        check = True
        break
    if cnt == 0:
        break
    answer += 1

if check:
    print(answer)
else:
    print(0)