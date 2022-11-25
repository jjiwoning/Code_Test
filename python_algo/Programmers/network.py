# 프로그래머스 Network

def solution(n, computers):
    answer = 0
    visited = [False] * n
    def dfs(n, computers, now, visited):
        visited[now] = True
        for i in range(n):
            if i != now and computers[now][i] == 1:
                if visited[i] == False:
                    dfs(n, computers, i, visited)

    for i in range(n):
        if visited[i] == False:
            dfs(n, computers, i, visited)
            answer += 1

    return answer