# 대회 or 인턴

import sys

def solution(n, m, k):
    answer = 0

    while True:
        if n >= 2 and m >= 1 :
            n -= 2
            m -= 1
            answer += 1
        else:
            if n + m >= k:
                return answer
            else:
                while n + m < k:
                    answer -= 1
                    n += 2
                    m += 1
                return answer
                

n, m, k = map(int, sys.stdin.readline().split())

print(solution(n, m, k))