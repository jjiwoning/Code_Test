import sys

m, n = map(int, sys.stdin.readline().split())

ls = []

for i in range(m):
    ls.append(int(sys.stdin.readline()))

ls.sort()

start = 1
end = ls[-1]

while start <= end:
    mid = (start + end) // 2
    cnt = 1
    ep = ls[0]
    for i in range(1, m):
        if ls[i] - ep >= mid:
            cnt += 1
            ep = ls[i]

    if cnt >= n:
        start = mid + 1
    else:
        end = mid - 1

print(end)