# 프로그래머스 가장 큰 수

from itertools import permutations
from math import factorial

def solution(numbers):
    numbers1 = list(map(str, numbers))
    numbersPer = list(permutations(numbers1, len(numbers)))
    numbersPer.sort(reverse = True)
    answer = []
    for i in range(factorial(len(numbers)-1)):
        maxNum = ''
        for j in range(len(numbers)):
             maxNum += numbersPer[i][j]
        answer.append(int(maxNum))
    answer.sort()
    return str(answer[-1])


numbers = [3, 30, 34, 5, 9]

print(solution(numbers))


