# 스택, 큐 프린터

def solution(priorities : list, location : int) -> int:
    indexList = []
    printList = []
    for i in range(len(priorities)):
        indexList.append(i)
    findNum = priorities[location]
    numIndex = indexList[location]
    while priorities != []:
        first = priorities[0]
        firstIndex = indexList[0]
        if first != max(priorities):
            priorities.pop(0)
            indexList.pop(0)
            priorities.append(first)
            indexList.append(firstIndex)
        else:
            priorities.pop(0)
            indexList.pop(0)
            printList.append(firstIndex)
    answer = printList.index(numIndex)
    return answer + 1
a = [2, 1, 3, 2]
lo = 2
print(solution(a, lo))