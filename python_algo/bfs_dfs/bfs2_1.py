from collections import deque
import sys

n = int(sys.stdin.readline())

apple = []

for i in range(n):
    apple.append(list(map(int, sys.stdin.readline().split())))

answer = 0
checked = [[False] * n for _ in range(n)]
dx = [1, -1, 0, 0]
dy = [0, 0, 1, -1]

s = e = n // 2
level = 0

def bfs(s, e):
    global answer
    global level
    q = deque()
    checked[s][e] = True
    answer += apple[s][e]
    q.append((s, e))
    while True:
        if level == n // 2:
            break
        size = len(q)
        for i in range(size):
            now = q.popleft()
            for j in range(4):
                x = now[0] + dx[j]
                y = now[1] + dy[j]
                if checked[x][y] == False:
                    answer += apple[x][y]
                    checked[x][y] = True
                    q.append((x, y))
        level += 1

bfs(s, e)
print(answer)