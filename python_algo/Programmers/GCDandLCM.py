# 최대공약수와 최소공배수

from math import gcd


def solution(n, m):
    a = gcd(n,m)
    b = n*m/a
    answer = [a, b]
    return answer