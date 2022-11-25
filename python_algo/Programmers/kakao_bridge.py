# 효율성에서 통과하지 못한 코드
# 효율성을 챙기기 위해서는 이진 탐색을 진행
def solution_fail(stones, k):
    answer = 0
    check = True

    while True:
        cnt = 0
        for i in range(len(stones)):
            if stones[i] == 0:
                cnt += 1
                if cnt == k:
                    check = False
                    break
            else:
                stones[i] -= 1
                cnt = 0
        if not check:
            break
        answer += 1

    return answer


def solution(stones, k):
    start = min(stones)
    end = max(stones)
    while start <= end:
        temp = stones.copy()
        mid = (start + end) // 2
        cnt = 0
        for i in temp:
            if i - mid <= 0:
                cnt += 1
            else:
                cnt = 0
            if cnt >= k:
                break

        if cnt >= k:
            end = mid - 1
        else:
            start = mid + 1
    return start

solution([2, 4, 5, 3, 2, 1, 4, 2, 5, 1]	, 3)
