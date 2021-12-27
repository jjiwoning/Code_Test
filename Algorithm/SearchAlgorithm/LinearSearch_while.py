# while문을 활용한 선형 검색 알고리즘

# 함수 구현
def LinearSearch_While(array, key):
    i = 0

    while True:
        if i == len(array): # 검색을 실패한 경우: key값이 없을때
            return -1
        if array[i] == key: # 검색을 성공한 경우: key값이 있을때
            return i
        i += 1

index = int(input("인덱스 값을 입력해주세요:"))
x = [None] * index

for i in range(index):
    x[i] = int(input("x[%d] 값을 입력해주세요:" %i))

wantedKey = int(input("원하는 key값을 입력해주세요"))

idx = LinearSearch_While(x, wantedKey)

if idx == -1:
    print("원하는 원소가 없습니다.")
else:
    print("원하는 값이 x[%d]에 있습니다" %idx)    
