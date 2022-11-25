# 휴가
import sys


def dfs(day, money):
    global result
    if day == n:
        if money > result:
            result = money
    else:
        if day + ls[day][0] <= n:
            dfs(day + ls[day][0], money + ls[day][1])
        dfs(day + 1, money)


if __name__ == '__main__':
    n = int(sys.stdin.readline())
    ls = []
    for i in range(n):
        today = list(map(int, sys.stdin.readline().split()))
        ls.append(today)
    result = -1
    print(ls)
    dfs(0, 0)
    print(result)
