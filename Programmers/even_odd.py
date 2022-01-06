# 홀, 짝 출력
def solution(num):
    if num % 2 == 0:
        answer = "Even"
    else:
        answer = "Odd"
    return answer

a = 3
print(solution(a))
