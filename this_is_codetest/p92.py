# 큰 수의 법칙

import sys

n, m, k = map(int, sys.stdin.readline().split())
num = list(map(int, sys.stdin.readline().split()))

# 2개의 큰 숫자만 찾으면 됨
num.sort()
num1 = num[-1]
num2 = num[-2]

answer = 0

while m:
    for i in range(k):
        answer += num1
        m -= 1
    answer += num2
    m -= 1

print(answer)