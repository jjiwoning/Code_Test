def solution(progresses, speeds):
    answer = []
    day = []
    for i in range(len(progresses)):
        num = (100 - progresses[i]) / speeds[i]
        if int(num) == num:
            day.append(int(num))
        else:
            day.append(int(num+1))
    
    return 

progresses = [93, 30, 55]
speeds = [1, 30, 5]
print(solution(progresses, speeds))