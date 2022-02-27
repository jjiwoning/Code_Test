# 피보나치 함수

import sys

# def fibo(n, cnt00, cnt11):
#     global cnt0, cnt1
#     cnt0 = cnt00
#     cnt1 = cnt11
#     if n == 0:
#         cnt0 += 1
#         return 0
#     elif n == 1:
#         cnt1 += 1
#         return 1
#     else:
#         return fibo(n-1, cnt0, cnt1) + fibo(n-2, cnt0, cnt1)

# t = int(sys.stdin.readline())
# for i in range(t):
#     n = int(sys.stdin.readline())
#     fibo(n, 0, 0)
#     print(cnt0, cnt1)

t = int(sys.stdin.readline())
 
zero = [1,0,1]
one = [0,1,1]
 
def fibo(n):
    length = len(zero)
    if length <= n:
        for i in range(length,n+1):
            zero.append(zero[i-1]+zero[i-2])
            one.append(one[i-1]+one[i-2])
    print(zero[n] , one[n])
 
for i in range(t):
    n = int(sys.stdin.readline())
    fibo(n)

