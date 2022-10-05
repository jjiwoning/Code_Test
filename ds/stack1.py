import sys

n, cnt = map(int, sys.stdin.readline().split())

n = str(n)

stack = []

for i in n:
    while stack and cnt > 0 and stack[-1] < i:
        stack.pop()
        cnt -= 1
    stack.append(i)

if cnt != 0:
    stack = stack[:-cnt]

print(stack)
