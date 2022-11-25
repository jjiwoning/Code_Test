# 다리를 지나는 트럭

from collections import deque

def solution(bridge_length, weight, truck_weights):

    answer = 0
    # 다리 길이 설정 -> 0으로 초기화 -> sum으로 계속 다리 무게 더하기
    # 해당 다리에 pop push를 계속 해주면서 시간 1씩 계산하기
    # 다리에 트럭이 들어가면 truck_weights에서 트럭 무게 넣고 안 들어가면 0 넣어서 트럭들 계속
    # 한 칸씩 전진하게 설정
    bridge = deque([0] * bridge_length)
    truck_weights = deque(truck_weights)

    bridgeSum = 0

    while bridge: # bridge에 아무것도 없는 순간이 answer기 때문에 while 조건으로 설정
        bridgeSum -= bridge[0] # 나가는 트럭 무게 빼주기
        bridge.popleft() # 트럭 탈출

        if truck_weights: # 더 이상 남은 트럭 없으면 0 넣어줄 필요 없음 -> if로 조건 설정
            if bridgeSum + truck_weights[0] > weight: # 해당 조건이면 트럭 못들어감
                bridge.append(0) # 0 넣어줘서 트럭 전진하게 해줌
            else: # 트럭 들어가는 조건
                bridgeSum += truck_weights[0] # 다리 무게 + 트럭 무게
                bridge.append(truck_weights.popleft()) # 트럭 다리에 진입
        
        answer += 1 # 해당 과정으로 1초 소모
    return answer


print(solution(2, 10, [7,4,5,6]))