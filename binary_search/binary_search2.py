import sys

n, target = map(int, sys.stdin.readline().split())

numbers = list(map(int, sys.stdin.readline().split()))

numbers.sort()

start = 0
end = len(numbers) - 1
answer = 0

while start <= end:
    mid = (start + end) // 2
    if numbers[mid] > target:
        end = mid - 1
    elif numbers[mid] < target:
        start = mid + 1
    else:
        answer = mid
        break

print(answer + 1)