# 가장 높은 탑 쌓기
import sys

N = int(sys.stdin.readline())
block = []
for i in range(N):
    block.append(list(map(int, sys.stdin.readline().split())))

block.sort(key = lambda x : -x[0])

print(block)

dp = [0] * N
dp[0] = block[0][1] # 높이

for i in range(1, N):
    maxHeight = 0
    for j in range(i):
        if block[j][2] > block[i][2] and dp[j] > maxHeight:
            maxHeight = dp[j]
    dp[i] = maxHeight + block[i][1]

print(max(dp))