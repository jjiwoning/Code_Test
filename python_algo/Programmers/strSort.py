# 문자열 내림차순으로 정렬하기

import sys

def solution(s):
    answer = sorted(s , reverse= True)
    answer = ''.join(answer)
    return answer

s = sys.stdin.readline().rstrip()

print(solution(s))