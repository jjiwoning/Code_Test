# 이진 탐색 알고리즘

def BinarySearch(a, key):
    pl = 0 # 배열의 맨 앞 인덱스 초기화
    pr = len(a) - 1 # 배열의 맨 뒤 인덱스 초기화

    while pl <= pr: # 종료 조건 : 더 이상 검색 범위가 없을때 -> 처음 인덱스가 끝 인덱스보다 커질때
        pc = (pl+pr) // 2 # 중앙 원소의 인덱스
        if a[pc] == key: # key값을 찾은 경우
            return pc
        elif a[pc] < key: # 중앙 값 보다 key 값이 큰 경우
            pl = pc + 1 # 오른쪽을 판별해야되기 때문에 pl에 pc + 1 할당
        elif a[pc] > key: # 중앙 값 보다 key 값이 작은 경우
            pr = pc - 1 # 왼쪽을 판별해야되기 때문에 pr에 pc - 1 할당
    
    return -1

x = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]
keyNum = int(input("1~10 중 찾고싶은 정수를 입력하세요"))

idx = BinarySearch(x, keyNum)

if idx == -1:
    print("못 찾았습니다")
else:
    print("찾고자 하는 수는 x[%d]에 있습니다" %idx)