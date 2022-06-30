# 더 맵게

import heapq

def solution(scoville, K):
    heapq.heapify(scoville)
    cnt = 0

    while scoville[0] < K:
        
        if len(scoville) <= 1:
            return -1

        a = heapq.heappop(scoville)
        b = heapq.heappop(scoville)
        new = a + 2 * b
        heapq.heappush(scoville, new)
        cnt += 1

    return cnt

print(solution([1, 10, 9, 3, 2, 12], 7))