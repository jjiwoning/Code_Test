# 떡볶이 떡 만들기

import sys

n, m = map(int,sys.stdin.readline().split())
arr = list(map(int,sys.stdin.readline().split()))

start = 0
end = max(arr)

answer = 0

while start <= end:
    total = 0
    mid = (start + end)//2

    for i in arr:
        if i - mid > 0:
            total += i - mid
    
    if total < m:
        end = mid - 1
    else:
        result = mid
        start = mid + 1

print(result)