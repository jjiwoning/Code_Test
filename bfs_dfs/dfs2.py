import sys

n = int(input())

ls = list(map(int, input().split()))

def dfs(number, sum1):

    if sum1 > sum(ls)//2:
        return

    if number == n:
        if sum1 == sum(ls) - sum1:
            print("YES")
            sys.exit(0)
    else:
        dfs(number + 1, sum1 + ls[number])
        dfs(number + 1, sum1)

if sum(ls) % 2 == 1:
    print("NO")

dfs(0, 0)

print("NO")