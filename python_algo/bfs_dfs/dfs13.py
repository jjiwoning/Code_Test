# 동전 바꿔주기
import sys


def dfs(level, money):
    global answer
    if money > T:
        return
    if money == T:
        answer += 1
    elif level == k:
        return
    else:
        now_money = money_list[level][0]
        cnt = money_list[level][1]
        for i in range(cnt + 1):
            dfs(level + 1, money + now_money * i)


if __name__ == '__main__':
    T = int(sys.stdin.readline())
    k = int(sys.stdin.readline())
    money_list = []
    for i in range(k):
        ls = list(map(int, sys.stdin.readline().split()))
        money_list.append(ls)

    answer = 0
    dfs(0, 0)

    print(answer)