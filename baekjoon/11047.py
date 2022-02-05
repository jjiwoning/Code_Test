# 동전 0

import sys

n, k = map(int, sys.stdin.readline().split())
moneyList = []

for i in range(n):
    moneyList.append(int(sys.stdin.readline()))

cnt = 0
# 리스트 뒤집기 (내림차순)
moneyList.reverse()

# 몫 -> 카운트 , 나머지 -> 잔돈
for i in moneyList:
    cnt += k//i
    k = k%i
    
print(cnt)