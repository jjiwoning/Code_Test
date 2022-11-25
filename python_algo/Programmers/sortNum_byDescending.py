# 정수 내림차순으로 정렬하기

def solution(n):
    numbers = list(str(n))
    numbers.sort(reverse = True)
    answer = ''.join(numbers)
    return answer

n = 7655932

print(solution(n))