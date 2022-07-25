# 무지의 먹방 라이브

import heapq

def solution(food_time, k):
    queue = []

    for i in range(len(food_time)):
        # (음식 시간, 음식 번호) 형태로 큐에 넣는다.
        heapq.heappush(queue, (food_time[i], i + 1))

        sum = 0 # 음식을 먹기 위해 사용한 시간 총 합
        previous = 0 # 직전에 다 먹은 음식 시간
        length = len(food_time) # 남은 음식 갯수

        while sum + ((queue[0][0] - previous) * length) <= k:
            now = heapq.heappop(queue)[0]
            sum += (now - previous) * length
            length -= 1 # 다 먹은 음식 제외 (큐에서 빠졌음)
            previous = now # 이전 음식 시간 재설정
        
        result = sorted(queue, key = lambda x : x[1])
        return result[(k - sum) % length][1]
    



foodtime = [3, 1, 2]
k = 5

ans = solution(foodtime, k)
print(ans)


