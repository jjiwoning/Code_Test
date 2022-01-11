# 큰 수의 법칙

import sys

N, M, K = map(int, sys.stdin.readline().split())
array = list(map(int, sys.stdin.readline().split()))

# 내가 풀어본 코드
array.sort()
max = 0
trial = 1
while trial <= M:
    for i in range(K):
        max += array[-1]
        trial +=1
        if trial >=M:
            break
    if trial > M:
        break
    max += array[-2]
    trial +=1

# 답안 코드
array.sort()
first = array[-1]
second = array[-2]
result = 0
while True:
    for i in range(K):
        if M == 0:
            break
        result += first
        M -= 1
    if M == 0:
        break
    result += second
    M -= 1

print(max)


    