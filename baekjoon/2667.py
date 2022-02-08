# 단지 번호 붙이기

import sys

# 재귀 깊이 제한 함수 깊이 제한 default = 1000
sys.setrecursionlimit(100000)

n = int(sys.stdin.readline())
graph = []
for i in range(n):
    graph.append(list(map(int, sys.stdin.readline().strip())))

cnt = -1

def dfs(x, y, cnt):
    if x <= -1 or x >=n or y <= -1 or y>= n:
        return False
    if graph[x][y] == 1:
        graph[x][y] = cnt
        dfs(x-1, y, cnt)
        dfs(x, y-1, cnt)
        dfs(x+1, y, cnt)
        dfs(x, y+1, cnt)
        return True
    return False

result = 0
for i in range(n):
    for j in range(n):
        if dfs(i,j, cnt) == True:
            result += 1
            cnt -= 1

apartList = []

print(result)
for i in range(-1, cnt, -1):
    a = 0
    for j in range(n):
        a += graph[j].count(i)
    apartList.append(a)

apartList.sort()

for i in range(len(apartList)):
    print(apartList[i])