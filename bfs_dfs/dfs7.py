n, time = map(int, input().split())

problem = []

for i in range(n):
    s, t = map(int, input().split())
    problem.append([s, t])

maxScore = 0
checked = [False] * n

def dfs(level, totalTime, score):
    global maxScore

    if totalTime > time:
        return

    if level < n:
        dfs(level + 1, totalTime + problem[level][1], score + problem[level][0])
        dfs(level + 1, totalTime, score)
    elif level == n:
        if maxScore < score:
            maxScore = score
        return

dfs(0, 0, 0)

print(maxScore)