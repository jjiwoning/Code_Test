n = int(input())
a = list(map(int, input().split()))
m = int(input())

result = m

a.sort(reverse = True)

def dfs(level, sum):
    global result
    if level > result:
        return
    if sum > m:
        return
    if sum == m:
        if level < result:
            result = level
            return
    else:
        for i in range(n):
            dfs(level + 1, sum + a[i])

dfs(0, 0)

print(result)