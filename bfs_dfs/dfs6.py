import sys

sys.setrecursionlimit(1500000)

n, m = map(int, input().split())

ls =[[] for _ in range(n + 1)]

for i in range(m):
    a, b = map(int, input().split())
    ls[a].append(b)

visited = [False] * (n + 1)
visited[1] = True

cnt = 0
def dfs(level):
    global cnt
    if level == n:
        cnt += 1
        return
    else:
        for i in ls[level]:
            if not visited[i]:
                visited[i] = True
                dfs(i)
                visited[i] = False

dfs(1)

print(cnt)