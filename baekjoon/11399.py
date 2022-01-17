# ATM 11399

import sys
sys.setrecursionlimit(10**3 + 5)
def soultion(n : int, p : list) -> int:
    p.sort()
    sum = 0
    if n == 0:
        return 0
    for i in range(n):
        sum += p[i]
    return sum + soultion(n-1, p)

n = int(sys.stdin.readline())
p = list(map(int, sys.stdin.readline().split()))

print(soultion(n, p))


