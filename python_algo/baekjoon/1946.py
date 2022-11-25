# 백준 1946 신입 사원

import sys

def solution(score):
    answer = 1 # 정렬이 되고 첫번째 지원자는 무조건 합격
    score.sort() # 점수 정렬
    min = score[0][1] # 첫 번째 지원자의 면접시험 점수
    for i in score:
        if i[1] < min: # 이 조건이면 합격
            answer += 1
            min = i[1]
    return answer


T = int(sys.stdin.readline())
for _ in range(T):
    n = int(sys.stdin.readline())
    score = []
    for __ in range(n):
        a, b = map(int, sys.stdin.readline().split())
        score.append([a, b])
    print(solution(score))
