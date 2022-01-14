# 정렬 k번째 수

def solution(array, commands):
    answer = []
    for i in range(len(commands)):
        newArray = array[(commands[i][0]-1):(commands[i][1])]
        newArray.sort()
        findNum = newArray[commands[i][2]-1]
        answer.append(findNum)
    return answer