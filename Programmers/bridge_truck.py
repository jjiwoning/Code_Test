# 다리를 지나는 트럭

from collections import deque

def solution(bridge_length, weight, truck_weights):

    answer = 0
    bridge = deque([0] * bridge_length)
    truck_weights = deque(truck_weights)

    while bridge:
        bridge.popleft()

        if truck_weights:
            if sum(list(bridge)) + truck_weights[0] > weight:
                bridge.append(0)
            else:
                bridge.append(truck_weights)
        
        answer += 1

    return answer


print(solution(2, 10, [7,4,5,6]))