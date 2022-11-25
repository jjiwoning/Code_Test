# 나이트의 이동
import sys
from collections import deque

def bfs(x, y, graph, endX, endY, size):
    queue = deque()
    queue.append((x,y))
    # 현 위치가 도착지이면 0 바로 리턴해버리기.
    if x == endX and y == endY:
        return 0
    while queue:
        x, y = queue.popleft()
        for i in range(8): # -> 8 방향으로 움직임
            nx = x + dx[i]
            ny = y + dy[i]
            # 체스판에서 벗어나면 continue 
            if nx < 0 or ny < 0 or nx >= size or ny >= size:
                continue
            # 처음 도착한 장소일때
            if graph[nx][ny] == 0:
                # 해당 위치의 그래프에 값을 더 해준다.
                graph[nx][ny] = graph[x][y] + 1
                # 큐에 해당 위치 추가
                queue.append((nx, ny))
    # 도착지의 graph 값 리턴
    return graph[endX][endY]    

# 나이트 이동 방향
dx = [-2,-1, 2, 1, -2, -1, 2, 1]
dy = [1, 2, 1, 2, -1, -2, -1, -2]
# 체스판 그래프
size = []
# 나이트 위치
now = []
# 원하는 방향
end = []
# 입력
t = int(sys.stdin.readline())
for i in range(t):
    size.append(int(sys.stdin.readline()))
    now.append(list(map(int, sys.stdin.readline().split())))
    end.append(list(map(int, sys.stdin.readline().split())))

for i in range(t):
    graph = [[0] * size[i] for _ in range(size[i])]
    print(bfs(now[i][0], now[i][1], graph, end[i][0], end[i][1], size[i]))
