from collections import deque
import sys

n = int(sys.stdin.readline())

student = list(map(int, sys.stdin.readline().split()))
student.sort()
student = deque(student)

answer = 200000

while student:
    w = student.pop() + student.popleft()
    if w < answer:
        answer = w

print(answer)