import sys

n = int(sys.stdin.readline())

dy = [0] * (n + 1)

def dp(number):

    if dy[number] > 0:
        return dy[number]

    if number == 1 or number == 2:
        return number
    else:
        dy[number] = dp(number - 1) + dp(number - 2)
        return dy[number]

print(dp(n))