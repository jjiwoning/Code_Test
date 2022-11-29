# 프로그래머스 명예의 전당
from collections import deque


def solution(k, score):
    now = []
    answer = []

    for i in score:
        now.append(i)
        now.sort(reverse=True)
        if len(now) > k:
            now.pop()
        answer.append(now[-1])
    return answer


print(solution(3, 1))