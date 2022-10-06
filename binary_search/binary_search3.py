import sys

n, cnt = map(int, sys.stdin.readline().split())
lan = []
for i in range(n):
    lan.append(int(sys.stdin.readline()))

start = 1
end = max(lan)

while start <= end:
    mid = (start + end) // 2
    find = 0
    for i in lan:
        find += i // mid
    if find >= cnt:
        start = mid + 1
    else:
        end = mid - 1

print(end)