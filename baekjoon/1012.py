#유기농 배추

import sys

sys.setrecursionlimit(15000)

t = int(sys.stdin.readline())

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def dfs(x, y):
    if x < 0 or x >= m or y < 0 or y >= n or ls[x][y] == 0:
        return False
    else:
        ls[x][y] = 0
        for i in range(4):
            dfs(x + dx[i], y + dy[i])
        return True

for i in range(t):
    m, n, k = map(int, sys.stdin.readline().split())
    ls = [[0] * n for _ in range(m)]
    for i in range(k):
        x, y = map(int, sys.stdin.readline().split())
        ls[x][y] = 1
    
    answer = 0

    for i in range(m):
        for j in range(n):
            if dfs(i, j) == True:
                answer += 1
    
    print(answer)
    

