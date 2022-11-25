import sys

def factorial(n):
    if n == 1:
        return 1
    if n == 0:
        return 1
    return n*factorial(n-1)
    
n = int(sys.stdin.readline())

print(factorial(n))
