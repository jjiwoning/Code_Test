
n, m = map(int, input().split())

answer = []
cnt = 0
cnt1 = 0
result = [0] * m

def dfs(answer):
    global cnt
    if len(answer) == m:
        for j in answer:
            print(j, end=" ")
        cnt += 1
        print()
        return
    else:
        for i in range(1, n + 1):
            dfs(answer + [i])

def dfs2(level):
    global cnt1
    if level == m:
        for i in result:
            print(i, end = " ")
        cnt1 += 1
        print()
    else:
        for i in range(1, n + 1):
            result[level] = i
            dfs2(level + 1)

dfs(answer)
print(cnt)

dfs2(0)
print(cnt1)
