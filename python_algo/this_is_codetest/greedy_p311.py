# 모험가 길드

import sys

n = int(sys.stdin.readline())
nList = list(map(int, sys.stdin.readline().split()))

nList.sort()

result = 0 # 결성된 그룹의 수
cnt = 0 # 현재 그룹의 인원

for i in nList:
    cnt += 1 # 그룹의 인원 + 1
    if cnt >= i : # 그룹의 인원이 개인의 공포도 보다 크다면 -> 그룹 결성 조건 만족
        result += 1 # 그룹 추가
        cnt = 0 # 새 그룹의 인원은 0으로 초기화

print(result)