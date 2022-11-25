def solution(progresses, speeds):
    answer = []
    day = []
    for i in range(len(progresses)):
        num = (100 - progresses[i]) / speeds[i]
        if int(num) == num:
            day.append(int(num))
        else:
            day.append(int(num+1))
    cnt = 1
    # 아래의 for문 구조 이해하기
    for i in range(1, len(day)):
        if day[i - cnt] >= day[i]:
            cnt += 1
        else:
            answer.append(cnt)
            cnt = 1
    answer.append(cnt)                
    return answer

progresses = [93, 30, 55]
speeds = [1, 30, 5]
print(solution(progresses, speeds))