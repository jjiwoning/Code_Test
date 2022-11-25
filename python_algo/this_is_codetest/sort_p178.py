# 위에서 아래로

import sys

n = int(sys.stdin.readline())

answer = []

for i in range(n):
    answer.append(int(sys.stdin.readline()))

answer.sort(reverse = True)

print(*answer)