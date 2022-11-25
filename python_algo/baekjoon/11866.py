# 요세푸스 문제

import sys

from collections import deque

n, k = map(int,sys.stdin.readline().split())

circle = deque(list(range(1, n+1)))
ans = []

while True:
    if list(circle) == []:
        break
    cnt = k
    while True:
        a = circle.popleft()
        cnt -= 1
        if cnt == 0:
            ans.append(a)
            break
        circle.append(a)

print("<", end = "")
for i in range(len(ans)-1):
    print(ans[i], end = ', ')
print(ans[-1], end='')
print(">")
