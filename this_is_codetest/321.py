# 럭키 스트레이트

import sys

s = sys.stdin.readline().rstrip()

length = len(s)

s1 = s[:(len(s)//2)]
s2 = s[(len(s)//2 ):]

sum1 = 0
sum2 = 0

for i in s1:
    i = int(i)
    sum1 += i

for i in s2:
    i = int(i)
    sum2 += i

if(sum1 == sum2):
    print("LUCKY")
else:
    print("READY")

