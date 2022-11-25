# 최대 선 연결하기
import sys

N = int(sys.stdin.readline())
ls = list(map(int, sys.stdin.readline().split()))

dp = [0] * N
dp[0] = 1

for i in range(1, N):
    maxElement = 0
    for j in range(i):
        if ls[i] > ls[j] and dp[j] > maxElement:
            maxElement = dp[j]
    dp[j] = maxElement + 1

print(max(dp))



