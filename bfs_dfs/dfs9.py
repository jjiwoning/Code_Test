import sys

n, m = map(int, sys.stdin.readline().split())

checked = [False] * (n + 1)
cnt = 0

def dfs(level, s):
    global cnt
    if level == m:
        for i in range(1, len(checked)):
            if checked[i] == True:
                print(i, end = " ")
        cnt += 1
        print()
    else:
        for i in range(s, n + 1):
            if not checked[i]:
                checked[i] = True
                dfs(level + 1, i + 1)
                checked[i] = False

dfs(0, 1)
print(cnt)