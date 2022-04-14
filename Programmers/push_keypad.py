# 키패드 누르기
def solution(numbers, hand):
    answer = ''
    graph = [
        [1,0], #0
        [0,3], #1
        [1,3], #2
        [2,3], #3
        [0,2], #4
        [1,2], #5
        [2,2], #6
        [0,1], #7
        [1,1], #8
        [2,1], #9
    ]
    handDict = {"right":"R", "left":"L"}
    rightHand = [2,0]
    leftHand = [0,0]
    for i in range(len(numbers)):
        if numbers[i] in [1, 4, 7]:
            leftHand = graph[numbers[i]]
            answer += "L"
        elif numbers[i] in [3, 6, 9]:
            rightHand = graph[numbers[i]]
            answer += "R"
        else:
            rightLen = abs(rightHand[0] - graph[numbers[i]][0]) + abs(rightHand[1] - graph[numbers[i]][1])
            leftLen = abs(leftHand[0] - graph[numbers[i]][0]) + abs(leftHand[1] - graph[numbers[i]][1])
            
            if rightLen > leftLen:
                leftHand = graph[numbers[i]]
                answer += 'L'
            elif leftLen > rightLen:
                rightHand = graph[numbers[i]]
                answer += 'R'
            else:
                if hand == "right":
                    rightHand = graph[numbers[i]]
                    answer += handDict[hand]
                else:
                    leftHand = graph[numbers[i]]
                    answer += handDict[hand]
                
    return answer

num = [7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2]	
hand = "left"

print(solution(num, hand))