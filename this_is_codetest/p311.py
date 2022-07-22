# 모험가 길드

import sys

n = int(sys.stdin.readline())
people = list(map(int, sys.stdin.readline().split()))

people.sort()

answer = 0
cnt = 0

for i in people:
    cnt += 1
    if i >= cnt:
        answer += 1
        cnt = 0

print(answer)