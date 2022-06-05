
def solution(arr):
    if len(arr) == len(list(set(arr))):
        return [-1]
    answer = []
    ansDict = {}
    for i in arr:
        if i not in ansDict:
            ansDict[i] = 1
        else:
            ansDict[i] += 1
    key = list(ansDict.keys())
    key.sort()
    for i in key:
        if ansDict[i] > 1: 
            answer.append(ansDict[i])
    return answer
    

print(solution([1, 2, 3, 4, 4, 5, 6, 7, 8, 8, 8, 8, 8, 8, 8, 8]))