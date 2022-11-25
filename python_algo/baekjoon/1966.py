from collections import deque
import sys

n = int(sys.stdin.readline())

for i in range(n):

    m, find = map(int, sys.stdin.readline().split())

    ls = list(map(int, sys.stdin.readline().split()))

    ls1 = [i for i in range(m)]
    maxValue = max(ls)

    q = deque(ls)
    q1 = deque(ls1)

    cnt = 0

    while True:
        if q[0] == maxValue:
            q.popleft()
            num = q1.popleft()
            if q:
                maxValue = max(q)
            cnt += 1
            if num == find:
                break
        else:
            q.append(q.popleft())
            q1.append(q1.popleft())
            

    print(cnt)