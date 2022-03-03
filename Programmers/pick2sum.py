# 두 개 뽑아서 더하기

from itertools import combinations
import sys


def solution(numbers):
    comb = list(combinations(numbers , 2))
    answer = []
    for i in range(len(comb)):
        answer.append(sum(comb[i]))
    answer = list(set(answer))
    return sorted(answer)


num = [5,0,2,7]
print(solution(num))