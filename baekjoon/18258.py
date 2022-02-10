# 큐2

from collections import deque
import sys


n = int(sys.stdin.readline())

queue = deque()

for i in range(n):
    action = sys.stdin.readline().strip()
    if action == "pop":
        if queue:#list(queue) != []:
            print(queue.popleft())
        else:
            print(-1)
    elif action == "size":
        print(len(queue))
    elif action == "empty":
        if queue:#list(queue) != []:
            print(0)
        else:
            print(1)
    elif action == "back":
        if queue:#list(queue) != []:
            print(queue[-1])
        else:
            print(-1)
    elif action == "front":
        if queue:#list(queue) != []:
            print(queue[0])
        else:
            print(-1)
    else:
        pushNum = int(action[5:])
        queue.append(pushNum)
