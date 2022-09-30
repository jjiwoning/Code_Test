
n, m = map(int, input().split())

checked = [False] * (n + 1)
numbers = [0] * m
cnt = 0

def dfs(level):
    global cnt
    if level == m:
        for i in numbers:
            print(i, end = " ")
        cnt += 1   
        print()
        return
    else:
        for i in range(1, n + 1):
            if not checked[i]:
                numbers[level] = i
                checked[i] = True
                dfs(level + 1)
                checked[i] = False

dfs(0)
print(cnt)

