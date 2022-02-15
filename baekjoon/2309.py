# 일곱 난쟁이

from itertools import combinations
import sys

people = []

for i in range(9):
    people.append(int(sys.stdin.readline()))

peopleComb = list(combinations(people, 7))

for i in range(len(peopleComb)):
    if sum(peopleComb[i]) == 100:
        answer = list(peopleComb[i])


answer.sort()

for i in range(len(answer)):
    print(answer[i])
