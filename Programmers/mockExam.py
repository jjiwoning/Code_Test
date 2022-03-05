# 모의고사

def solution(answers):
    student1 = [1, 2, 3, 4, 5] * 2000
    student2 = [2, 1, 2, 3, 2, 4, 2, 5] * 1250
    student3 = [3, 3, 1, 1, 2, 2, 4, 4, 5, 5] * 1000
    count1 = 0
    count2 = 0
    count3 = 0
    answer = []
    for i in range(len(answers)):
        if answers[i] == student1[i]:
            count1 += 1
        if answers[i] == student2[i]:
            count2 += 1
        if answers[i] == student3[i]:
            count3 += 1

    maxScore = max(count1, count2, count3)

    if count1 == maxScore:
        answer.append(1)
    
    if count2 == maxScore:
        answer.append(2)

    if count3 == maxScore:
        answer.append(3)
    return answer