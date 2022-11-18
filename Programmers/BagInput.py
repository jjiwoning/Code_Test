import itertools

count = 0

def solution(n, k, t, arr):

    for i in range(k, n + 1):
        dfs(0, 0, 0, i, t, arr)

    return count

def dfs(level, s, elementSum, k, t, arr):
    global count

    if level == k:
        if elementSum <= t:
            count += 1
    else:
        for i in range(s, len(arr)):
            dfs(level + 1, i + 1, elementSum + arr[i], k, t, arr)


i = solution(5, 3, 11, [2, 5, 3, 8, 1])
print(i)
