# 삽입 정렬
# 데이터를 하나씩 확인하며, 각 데이터를 적절한 위치에 삽입
# 두 번째 데이터부터 삽입 정렬 시작. -> 첫 데이터는 정렬이 완료되어 있다고 가정

array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(1, len(array)): # 두 번째 데이터부터 시작
    for j in range(i, 0, -1): # i에서 0번째까지 데이터에서 어디에 들어갈지 판별하기 위해
        if array[j] < array[j - 1]: # 한칸씩 왼쪽으로 이동
            array[j] , array[j - 1] = array[j -1], array[j]
        else:
            break

print(array)
