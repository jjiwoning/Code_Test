m, n = map(int, input().split())

dogs = []
answer = 0

for i in range(n):
    dogs.append(int(input()))

total = sum(dogs)

def dfs(level, kg, tsum):
    global answer

    if kg + (total - tsum) < answer:
        return

    if level == len(dogs):
        if answer < kg:
            if kg <= m:
                answer = kg
    else:
        dfs(level + 1, kg + dogs[level], tsum + dogs[level])
        dfs(level + 1, kg, tsum + dogs[level])

dfs(0, 0, 0)

print(answer)