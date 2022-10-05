import sys

n = int(sys.stdin.readline())

d = [0] * (n + 1)


def dp(num):
    if num == 1 or num == 2:
        return num
    if d[num] != 0:
        return d[num]

    d[num] = dp(num - 1) + dp(num - 2)
    return d[num]


def bottomUp(num):
    if num == 1 or num == 2:
        return num
    b = [0] * (n + 1)
    b[1] = 1
    b[2] = 2
    for i in range(3, num + 1):
        b[i] = b[i - 1] + b[i - 2]

    return b[num]


print(dp(n))
print(bottomUp(n))
