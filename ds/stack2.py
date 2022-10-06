import sys

n = sys.stdin.readline().rstrip()

stack = []
answer = 0

for i in range(len(n)):
    if n[i] == '(':
        stack.append(i)
    elif n[i] == ')':
        if n[i - 1] == '(':
            stack.pop()
            answer += len(stack)
        elif n[i - 1] == ')':
            stack.pop()
            answer += 1

print(answer)