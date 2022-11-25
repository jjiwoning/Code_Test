# 숫자 카드 게임
import time
start = time.time()
import sys
# 내가 쓴 풀이
row , col = map(int, sys.stdin.readline().split()) # 행,열 입력 받기
min = [None]*row # 최솟값의 리스트 생성

for i in range(row):
    list1 = list(map(int, sys.stdin.readline().split())) # 행 별로 row값 입력 받기
    list1.sort() # 리스트 정렬 -> 다른 방법) min() 함수 사용하면 됨
    min[i] = list1[0] # 최솟값의 리스트에 최솟값 넣어두기

min.sort() # 리스트 정렬 -> 최대값을 찾기 위해
print(min[-1])
end = time.time()
print(end-start)

# min 함수를 사용하는 예시
# result = 0
# for i in range(row):
#     data = list(map(int, sys.stdin.readline().split()))
#     min_value = min(data)
#     result = max(result, min_value)