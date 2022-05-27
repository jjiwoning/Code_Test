# 소수 찾기 - 완전 탐색

from itertools import permutations

def prime(key):
    if key == 1 or key == 0:
        return 0
    for i in range(2, int(key**(0.5)+ 1)):
        if key % i == 0:
            return 0
    return 1

def solution(numbers):
    answer = 0
    num = []
    numbers = list(numbers)
    
    for i in range(1, len(numbers) + 1):
        a = [''.join(k) for k in permutations(numbers, i)]
        num += a

    num = list(map(int, num))
    num = list(set(num))

    for i in num:
        if prime(i) == 1:
            answer += 1
        
    return answer


print(solution("011"))