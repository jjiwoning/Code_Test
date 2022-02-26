# 나무 자르기

import sys

n, m = map(int, sys.stdin.readline().split())
arr = list(map(int, sys.stdin.readline().split()))

start = 0
end = max(arr)
total = 0

while start <= end:
    result = 0
    mid = (start + end) // 2
    for i in arr:
        if i > mid:
            result += i - mid
    
    if result < m:
        end = mid - 1
    else:
        total = mid
        start = mid + 1


print(total)

