# 카드 2

from collections import deque

n = int(input())

queue = deque(list(range(1, n+1)))

while True:
    if len(queue) == 1:
        break
    queue.popleft()
    a = queue.popleft()
    queue.append(a)

print(queue[0])