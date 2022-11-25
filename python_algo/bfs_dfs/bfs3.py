from collections import deque
import sys

graph = []

for i in range(7):
    graph.append(list(map(int, sys.stdin.readline().split())))

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

def bfs(s, e):
    q = deque()
    q.append((s, e))

    while q:
        x, y = q.popleft()

        if x == y == 6:
            break

        for i in range(4):
            mx = x + dx[i]
            my = y + dy[i]
            if 0 <= mx < 7 and 0 <= my < 7:
                if graph[mx][my] == 0:
                    graph[mx][my] = graph[x][y] + 1
                    q.append((mx, my))

bfs(0, 0)

if graph[6][6] == 0:
    print(-1)
else:
    print(graph[6][6])