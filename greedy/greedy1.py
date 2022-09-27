#회의실 배정

from select import kevent


def solution(arr):
    arr.sort(key = lambda x : (x[1], x[0]))
    cnt = 0
    beforeEnd = 0
    for i in arr:
        if beforeEnd <= i[0]:
            beforeEnd = i[1]
            cnt += 1
    
    return cnt

n = int(input())

ls = []

for i in range(n):
    ls.append(list(map(int, input().split())))

print(solution(ls))