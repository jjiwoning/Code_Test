from collections import deque
import sys

n, k = map(int, sys.stdin.readline().split())

ls = []

start = []

for i in range(n):
    ls.append(list(map(int, sys.stdin.readline().split())))
    for j in range(len(ls[i])):
        if ls[i][j] != 0:
            start.append((ls[i][j], i, j))

s, findX, findY = map(int, sys.stdin.readline().split())

start.sort(key = lambda x : x[0])
q = deque(start)

dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

cnt = 0

while q:

    if cnt == s:
        break

    length = len(q)
    for i in range(length):
        a, x, y = q.popleft()
        for j in range(4):
            mx = x + dx[j]
            my = y + dy[j]
            if 0 <= mx < n and 0 <= my < n and ls[mx][my] == 0:
                ls[mx][my] = ls[x][y]
                q.append((a, mx, my))
    
    cnt += 1

print(ls[findX - 1][findY - 1])

