import sys

n = sys.stdin.readline().rstrip()

arr = [0] * 26

for i in n:
    num = ord(i) - ord('a')
    arr[num] += 1

print(*arr)