# 퀵 정렬
# 기준을 설정한 다음 큰 수와 작은 수를 교환하고 리스트를 반으로 나누는 방식으로 동작
# 기준으로 삼는 것을 pivot 이라고 한다.
# 호어 분할 방식에서는 리스트의 첫 번째 데이터를 pivot으로 정한다.

array = [5, 7, 9, 0, 3, 1, 6, 2, 4, 8]

def quick_sort(array, start, end):
    if start >= end: # 원소가 1개일때 종료
        return
    pivot = start # pivot은 첫 번째 원소
    left = start + 1
    right = end
    while left <= right:
        # pivot보다 큰 데이터를 찾을 때까지 반복 (시작 기준)
        while left <= end and array[left] <= array[pivot]:
            left += 1
        # pivot보다 작은 데이터를 찾을 때까지 반복 (끝 기준)
        while right > start and array[right] >= array[pivot]:
            right -= 1
        if left > right: # 둘이 엇갈렸다면, 작은 데이터와 pivot을 swap
            array[right], array[pivot] = array[pivot], array[right]
        else: # 둘이 엇갈리지 않았다면, 작은 데이터와 큰 데이터 swap
            array[right], array[left] = array[left], array[right]
    # 분할 이후 왼쪽, 오른쪽에서 다시 퀵 정렬 수행 (재귀 함수로 구현)
    quick_sort(array, start, right - 1)
    quick_sort(array, right + 1, end)

quick_sort(array, 0, len(array) - 1)
print(array)