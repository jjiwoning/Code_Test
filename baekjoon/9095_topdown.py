import sys

n = int(sys.stdin.readline())

def dp(number):
    if number <= 3:
        return 2 ** (number - 1)
    if d[number] != 0:
        return d[number]
    
    d[number] = dp(number - 1) + dp(number - 2) + dp(number - 3)
    return d[number]

for i in range(n):
    find = int(sys.stdin.readline())
    d = [0] * (find + 1)
    
    answer = dp(find)
    
    print(answer)

        