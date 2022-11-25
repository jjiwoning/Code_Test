from collections import deque
import sys

t = int(sys.stdin.readline())

def bfs():
    q = deque()
    q.append((home[0], home[1]))
    while q:
        x, y = q.popleft()
        if abs(x - festival[0]) + abs(y - festival[1]) <= 1000:
            print("happy")
            return
        for i in range(n):
            if not visited[i]:
                nx, ny = pyun[i]
                if abs(x - nx) + abs(y - ny) <= 1000:
                    q.append((nx, ny))
                    visited[i] = True
    print("sad")
    return

for i in range(t):
    n = int(sys.stdin.readline())
    home = list(map(int, sys.stdin.readline().split()))
    pyun = []
    for j in range(n):
        pyun.append(list(map(int, sys.stdin.readline().split())))
    festival = list(map(int, sys.stdin.readline().split()))
    visited = [False] * n
    bfs()