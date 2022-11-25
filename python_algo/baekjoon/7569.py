from collections import deque
import sys

m, n, h = map(int, sys.stdin.readline().split())

tomato = []

dx = [1, -1, 0, 0, 0, 0]
dy = [0, 0, 1, -1, 0, 0]
dz = [0, 0, 0, 0, 1, -1]

q = deque()

check = True

for i in range(h):
    temp = []
    for j in range(n):
        temp.append(list(map(int, sys.stdin.readline().split())))
        for k in range(m):
            if temp[j][k] == 1:
                q.append((i, j, k))
            if temp[j][k] == 0:
                check = False
    tomato.append(temp)

if check:
    print(0)
    sys.exit(0)

while q:
    x, y, z = q.popleft()

    for i in range(6):
        mx = x + dx[i]
        my = y + dy[i]
        mz = z + dz[i]
        if 0 <= mx < h and 0 <= my < n and 0 <= mz < m and tomato[mx][my][mz] == 0:
            tomato[mx][my][mz] = tomato[x][y][z] + 1
            q.append((mx, my, mz))

maxDay = 0

for i in tomato:
    for j in i:
        for k in j:
            if k == 0:
                print(-1)
                sys.exit(0)
        maxDay = max(maxDay, max(j))

print(maxDay - 1)
