# 피보나치 수

def pibo(n):
    if n == 1:
        return 1
    if n == 0:
        return 0
    return pibo(n-2) + pibo(n-1)

n = int(input())
print(pibo(n))