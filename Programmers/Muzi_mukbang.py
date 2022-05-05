#무지의 먹방 라이브
import heapq

def solution(food_times, k):
    if sum(food_times) <= k:
        return -1
    
    q = []
    # heapq를 이용해서 food_times가 짧은 음식부터 처리한다.
    for i in range(len(food_times)):
        #음식 시간, 음식 번호 순서로 heapq에 삽입 -> 이래야 음식 시간 순서로 힙큐가 정렬이 된다.
        heapq.heappush(q, (food_times[i], i + 1))

    sum_value = 0 # 먹기 위해 사용한 시간
    previous = 0 # 직전에 다 먹은 음식 시간
    length = len(food_times) # 남은 음식의 갯수

    # sum_value + (현재의 음식 시간 - 이전의 음식 시간) * 현재 음식 개수와 k를 비교
    while sum_value + (q[0][0] - previous) * length <= k:
        now = heapq.heappop(q)[0]
        sum_value += (now - previous) * length
        length -= 1 # 다 먹은 음식 리스트에서 삭제
        previous = now # 이전 음식 시간 재설정
    
    result = sorted(q, key = lambda x : x[1]) # 음식 번호 기준으로 정렬
    return result[(k - sum_value) % length][1]
    

food = [3, 1, 2]
k = 5
print(solution(food, k))


"""def solution(food_times, k):
    for i in range(len(food_times)):
        food_times[i] = food_times[i] - 1
    k = k - len(food_times)
    key = 0
    for i in range(k):
        if i >= len(food_times):
            n = i % len(food_times)
            cnt = 1
            while cnt:
                if food_times[n] >= 1:
                    food_times[n] = food_times[n] - 1
                    cnt -= 1
                    key = n
                else:
                    n = n + 1
                    if n >= len(food_times):
                        n = n % 3
        else:
            food_times[i] = food_times[i] - 1
            key = i
    while True:
        key = key + 1
        if key >= len(food_times):
            key = key % len(food_times)
        if food_times[key] > 0:
            answer = key
            break
    
    return answer if sum(food_times) > 0 else -1 """