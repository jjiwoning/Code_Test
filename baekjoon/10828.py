# 스택

import sys

n = int(sys.stdin.readline())

stack = []

for i in range(n):
    action = sys.stdin.readline().strip()
    if action == "pop":
        if stack != []:
            popNum = stack.pop()
            print(popNum)
        else:
            print(-1)
    elif action == "size":
        print(len(stack))
    elif action == "empty":
        if stack == []:
            print(1)
        else:
            print(0)
    elif action == "top":
        if stack != []:
            print(stack[-1])
        else:
            print(-1)
    else:
        pushNum = int(action[5:])
        stack.append(pushNum)
