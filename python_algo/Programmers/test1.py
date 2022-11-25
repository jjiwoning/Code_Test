from itertools import *

def solution(numbers):
    answer = 0
    makeNum = []
    
    for i in range(1, len(numbers) + 1):
        perm = list(permutations(numbers, i))
        for i in perm:
            i = ''.join(i)
            makeNum.append(i)
    
    makeNum = list(map(int, makeNum))
    makeNum = list(set(makeNum))
    
    for i in makeNum:
        if i == 1 or i == 0:
            continue
        a = True
        for j in range(2, int(i**(0.5)) + 1):
            if i % j == 0:
                a = False
                break
        if a == True:
            answer += 1
    return answer

print(solution("17"))