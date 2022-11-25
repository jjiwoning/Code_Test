# for문을 이용한 선형 탐색 알고리즘

def LinearSearch_for(a , key):
    for i in range(len(a)):
        if a[i] == key:
            return i # 검색 성공
    return -1 # 검색 실패 , 들여쓰기 주의

index = int(input("인덱스 값을 입력해주세요:"))
x = [None] * index

for i in range(index):
    x[i] = int(input("x[%d] 값을 입력해주세요:" %i))

wantedKey = int(input("원하는 key값을 입력해주세요"))

idx = LinearSearch_for(x, wantedKey)

if idx == -1:
    print("원하는 원소가 없습니다.")
else:
    print("원하는 값이 x[%d]에 있습니다" %idx)    