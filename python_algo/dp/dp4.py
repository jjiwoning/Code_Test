import sys

n = int(sys.stdin.readline())
arr = list(map(int, sys.stdin.readline().split()))
d = [0] * n
d[0] = 1
answer = 0

for i in range(1, n):
    maxVal = 0
    for j in range(i - 1, 0, -1):
        if arr[j] < arr[i] and d[j] > maxVal:
            maxVal = d[j]
    d[i] = maxVal + 1
    if d[i] > answer:
        answer = d[i]

print(answer)