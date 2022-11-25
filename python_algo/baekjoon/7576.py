from collections import deque
import sys

m, n = map(int, sys.stdin.readline().split())

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

tomato = []

for i in range(n):
    tomato.append(list(map(int, sys.stdin.readline().split())))

check = False

for i in tomato:
    for j in i:
        if j == 0:
          check = True
          break

if check == False:
    print(0)
    sys.exit(0)  

q = deque()

for i in range(n):
    for j in range(m):
        if tomato[i][j] == 1:
            q.append((i, j))

while q:
    x, y = q.popleft()
    for i in range(4):
        mx = x + dx[i]
        my = y + dy[i]
        if 0 <= mx < n and 0 <= my < m:
            if tomato[mx][my] == 0:
                tomato[mx][my] = tomato[x][y] + 1
                q.append((mx, my))


maxDay = 0


for i in tomato:
    for j in i:
        if j > maxDay:
            maxDay = j
        if j == 0:
            check = False
            break

if check == False:
    print(-1)
else:
    print(maxDay - 1)

