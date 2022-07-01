import sys

def solution(n, m, num):
    answer = 0
    sum = 0
    end = 0
    for start in range(n):
        while sum < m and end < n:
            sum += num[end]
            end += 1
        if sum == m:
            answer += 1
        sum -= num[start]
    return answer

n, m = map(int, sys.stdin.readline().split())
num = list(map(int, sys.stdin.readline().split()))

print(solution(n, m, num))

