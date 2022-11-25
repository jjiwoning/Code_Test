import sys

sys.setrecursionlimit(10000)

n, e = map(int, sys.stdin.readline().split())

ls = [[] for _ in range(n + 1)]

for i in range(e):
    a, b = map(int, sys.stdin.readline().split())
    ls[a].append(b)
    ls[b].append(a)

check = [False] * (n + 1)

def dfs(node):
    if check[node] == True:
        return
    else:
        check[node] = True
        for i in ls[node]:
            if check[i] == False:
                dfs(i)

answer = 0

for i in range(1, n + 1):
    if check[i] == False:
        dfs(i)
        answer += 1

print(answer)


