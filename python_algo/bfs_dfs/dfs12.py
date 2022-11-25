# 양팔저울
import sys


def dfs(level, weight):
    global result
    if level == len(ls):
        if 0 < weight <= maxW:
            result[weight] = True
    else:
        dfs(level + 1, weight + ls[level]) # 왼
        dfs(level + 1, weight) # x
        dfs(level + 1, weight - ls[level]) # 오


if __name__ == '__main__':
    n = int(sys.stdin.readline())
    ls = list(map(int, sys.stdin.readline().split()))
    maxW = sum(ls)
    result = [False] * (maxW + 1)
    dfs(0, 0)
    answer = 0
    for i in range(1, len(result)):
        if not result[i]:
            answer += 1
    print(answer)
