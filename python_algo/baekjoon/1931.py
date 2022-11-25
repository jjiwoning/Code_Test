import sys

def solution(ls):
    ls.sort(key = lambda x : x[0])
    ls.sort(key = lambda x : x[1])
    count = 0
    end = 0
    for i, j in ls:
        if i >= end:
            end = j
            count += 1
    return count

n = int(sys.stdin.readline())
ls = []
for i in range(n):
    ls.append(list(map(int, sys.stdin.readline().split())))

print(solution(ls))

