from collections import deque

n, m = map(int, input().split())

ls = list(map(int, input().split()))
ls.sort()
ls = deque(ls)

answer = 0

while ls:

    if len(ls) == 1:
        answer += 1
        break

    if ls[0] + ls[-1] > m:
        answer += 1
        ls.pop()
    else:
        answer += 1
        ls.pop()
        ls.popleft()

print(answer)