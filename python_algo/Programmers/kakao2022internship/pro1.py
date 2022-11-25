

def solution(survey, choices):
    answer = ''
    typeMap = {'R' : 0, 'T' : 0, 'C' : 0, 'F' : 0, 'J' : 0, 'M' : 0, 'A' : 0, 'N' : 0}

    for i in range(len(survey)):
        if choices[i] <= 4:
            typeMap[survey[i][0]] += (4 - choices[i])
        else:
            typeMap[survey[i][1]] += (choices[i] - 4)

    answer = findType(typeMap, 'R', 'T', answer)
    answer = findType(typeMap, 'C', 'F', answer)
    answer = findType(typeMap, 'J', 'M', answer)
    answer = findType(typeMap, 'A', 'N', answer)

    return answer


def findType(typeMap, A, B, answer):
    if typeMap[A] >= typeMap[B]:
        return answer + A
    return answer + B
