
n = int(input())

money = list(map(int, input().split()))
money.sort(reverse = True)

charge = int(input())

min = charge

def dfs(level, charge, cnt):
    global min
    if charge - money[level] == 0:
        if min > cnt + 1:
            min = cnt + 1
            return
    elif charge - money[level] < 0:
        return
    else:
        cnt += 1
        for i in range(len(money)):
            dfs(i, charge - money[i], cnt)

dfs(0, charge, 0)

print(min)