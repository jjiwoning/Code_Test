# 선택 정렬
# 정렬 알고리즘 중 가장 원시적인 알고리즘
# 원리 -> 가장 작은 데이터와 맨 앞 데이터를 계속 바꿔주면서 정렬한다.
# 시간 복잡도 O(n^2) -> 비효율적이다.

array = [7, 5, 9, 0, 3, 1, 6, 2, 4, 8]

for i in range(len(array)):
    min_index = i # 값이 가장 작은 원소가 들어가야되는 인덱스 (0 부터 시작)
    for j in range(i+1 , len(array)):
        # i 다음의 원소들을 i 번째 원소의 값과 비교 후 제일 작으면 swap 
        if array[min_index] > array[j]:
            # i 번째 원소의 값(min_index)이 j 번 째 원소의 값 보다 크다면
            # -> 최솟값을 찾았다면
            min_index = j # j가 최소값을 가지는 인덱스
    array[i], array[min_index] = array[min_index], array[i]

print(array) 
