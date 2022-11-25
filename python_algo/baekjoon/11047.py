# 동전 0

import sys

def solution(money, k):
    answer = 0
    money.reverse()
    for i in money:
        answer += (k // i)
        k = k % i
    return answer

n, k = map(int, sys.stdin.readline().split())
moneyList = []

for i in range(n):
    moneyList.append(int(sys.stdin.readline()))

money = moneyList

answer = solution(money, k)
print(answer)

# cnt = 0
# # 리스트 뒤집기 (내림차순)
# moneyList.reverse()

# # 몫 -> 카운트 , 나머지 -> 잔돈
# for i in moneyList:
#     cnt += k//i
#     k = k%i
    
# print(cnt)

