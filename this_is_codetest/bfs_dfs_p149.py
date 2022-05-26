# 음료수 얼려먹기 책 page 149p

import sys

n, m = map(int, sys.stdin.readline().split())
ice = []
for i in range(n):
    ice.append(list(map(int, sys.stdin.readline().rstrip())))

def dfs(x, y, graph):
    if x <= -1 or x >= n or y <= -1 or y >= m:
        return False
    if graph[x][y] == 0:
        graph[x][y] = 1
        dfs(x - 1, y, graph)
        dfs(x, y - 1, graph)
        dfs(x + 1, y, graph)
        dfs(x, y + 1, graph)
        return True
    return False

answer = 0
for x in range(n):
    for y in range(m):
        if dfs(x, y, ice) == True:
            answer += 1

print(answer)