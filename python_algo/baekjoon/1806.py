import sys

def solution(n, s, num):
    answer = []
    end = 0
    sum = 0
    for start in range(n):
        while sum < s and end < n:
            sum += num[end]
            end += 1
        if sum >= s:
            answer.append(end - start)
        sum -= num[start]

    if answer == []:
        return 0
    else:
        return min(answer)

n, s = map(int, sys.stdin.readline().split())
num = list(map(int, sys.stdin.readline().split()))
print(solution(n, s, num))