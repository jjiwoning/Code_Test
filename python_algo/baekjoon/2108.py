# 통계학

from collections import Counter
import sys


n = int(sys.stdin.readline())
numList = []

for i in range(n):
    num = int(sys.stdin.readline())
    numList.append(num)

numList.sort()

# 틀린 풀이 -> 시간 초과 발생함 
# numSet = set(numList)

# # 최빈값 구하는 과정
# cnt = 0
# # 최대 카운트 찾기
# for i in list(numSet):
#     a = numList.count(i)
#     if cnt <= a:
#         cnt = a

# manyList = []

# # 최대 카운트인 수들 리스트에 넣기
# for i in list(numSet):
#     if numList.count(i) == cnt:
#         manyList.append(i)

# # 조건에 맞춰서 최빈값 설정
# if len(manyList) == 1:
#     manyNum = manyList[0]
# else:
#     manyNum = manyList[1]
# # 최빈값 구하기 끝

# counter를 통해서 풀기
# Counter().most_common(a) -> 데이터의 개수가 많은 순으로 정렬된 배열을 a개의 원소로 리턴
cnt = Counter(numList).most_common(2)

if len(cnt) > 1:
    if cnt[0][1] == cnt[1][1]:
        manyNum = cnt[1][0]
    else:
        manyNum = cnt[0][0]
else:
    manyNum = cnt[0][0]

# 산술평균 round 함수로 반올림한다.
print(round(sum(numList)/len(numList)))
# 중앙값 //는 내림이다.
print(numList[n//2])
# 최빈값
print(manyNum)
# 범위
print(numList[-1]-numList[0])