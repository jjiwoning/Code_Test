# 나누어 떨어지는 숫자 배열

def solution(arr, divisor):
    answer = []
    for i in arr:
        if i % divisor == 0:
            answer.append(i)
    answer.sort()
    return answer if answer != [] else [-1]