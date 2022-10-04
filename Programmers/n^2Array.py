def solution(n, left, right):
    answer = []
    
    for i in range(left, right + 1):
        x = i // n # 몫
        y = i % n # 나머지
        if y + 1 == n: # 이 조건이면 무조건 n 들어감
            answer.append(n)
            continue

        if x + 1 == n: # 이 조건도 마찬가지로 무조건 n 들어감
            answer.append(n)
            continue

        if x >= y: # 몫이 나머지보다 큰 경우 -> ls[2][1] -> 3이 들어가는 순서라 x + 1
            answer.append(x + 1)
            continue
        
        answer.append(y + 1) # 위의 경우를 제외하고 남는 경우 ls[1][2] -> 3이 들어감 y + 1

    return answer

print(solution(3, 2, 5))