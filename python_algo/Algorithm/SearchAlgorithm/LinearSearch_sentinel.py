# 보초법을 사용한 선형 탐색 알고리즘
import copy

def LinearSearch_sentinel(a, key):
    x = copy.deepcopy(a) # 새로운 배열 x를 만들고 a를 복사
    x.append(key) # 배열 x에 key값을 가지는 원소 맨 뒤에 추가 (보초)

    i = 0
    while True:
        if x[i] == key:
            break # key값을 찾으면 탈출
        i +=1
    return -1 if i == len(x) else i # 찾거나 못 찾거나 둘 중 하나 리턴

index = int(input("인덱스 값을 입력해주세요:"))
x = [None] * index

for i in range(index):
    x[i] = int(input("x[%d] 값을 입력해주세요:" %i))

wantedKey = int(input("원하는 key값을 입력해주세요"))

idx = LinearSearch_sentinel(x, wantedKey)

if idx == -1:
    print("원하는 원소가 없습니다.")
else:
    print("원하는 값이 x[%d]에 있습니다" %idx)    