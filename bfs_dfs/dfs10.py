# 수들의 조합
import sys

N, K = map(int, sys.stdin.readline().split())
ls = list(map(int, sys.stdin.readline().split()))
M = int(sys.stdin.readline())
cnt = 0

def dfs(L, s, sum):
    global cnt
    if L == K:
        if sum % M == 0:
            cnt += 1
    else:
        for i in range(s, N):
            dfs(L + 1, i + 1, sum + ls[i])

dfs(0, 0, 0)

print(cnt)