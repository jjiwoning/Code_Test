import sys

n = int(sys.stdin.readline())

apple = []

for i in range(n):
    apple.append(list(map(int, sys.stdin.readline().split())))

answer = 0

s = e = n // 2

for i in range(n):
    for j in range(s, e + 1):
        answer += apple[i][j]
    if i < n // 2:
        s -= 1
        e += 1
    else:
        s += 1
        e -= 1

print(answer)