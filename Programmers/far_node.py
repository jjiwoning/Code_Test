from collections import deque


def solution(n, edge):
    answer = 0
    visited = [-1] * (n + 1)
    graph = [[] for _ in range(n + 1)]
    for a, b in edge:
        graph[a].append(b)
        graph[b].append(a)
    
    q = deque()

    q.append(1)
    visited[1] = 0

    while q:
        num = q.popleft()
        for i in graph[num]:
            if visited[i] == -1:
                visited[i] = visited[num] + 1
                q.append(i)
    
    maxVal = max(visited)

    for i in range(1, len(visited)):
        if visited[i] == maxVal:
            answer += 1

    return answer

