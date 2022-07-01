# 프로그래머스 네트워크 다시 풀어보기

def dfs(n, computers, now, visited):
    visited[now] = True

    for i in range(len(computers)):
        if i != now and computers[now][i] == 1:
            if visited[i] == False:
                dfs(n, computers, i, visited)


def solution(n, computers):
    answer = 0
    visited = [False] * n
    for i in range(n):
        if visited[i] == False:
            dfs(n, computers, i, visited)
            answer += 1
    return answer

print(solution(3, [[1, 1, 0], [1, 1, 0], [0, 0, 1]]))