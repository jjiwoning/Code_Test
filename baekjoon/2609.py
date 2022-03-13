# 최대공약수와 최소공배수

from math import gcd, lcm
import sys

a, b = map(int, sys.stdin.readline().split())

c = gcd(a,b)
d = lcm(a,b)

print(c)
print(d)