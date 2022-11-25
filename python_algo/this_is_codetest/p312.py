# 곱하기 혹은 더하기

import sys

s = sys.stdin.readline().rstrip()

ans = 1

for i in s:
    num = int(i)
    if num == 0:
        continue
    if num == 1:
        if ans == 1:
            continue
        else:
            ans += 1
    if num > 1:
        ans *= num

print(ans)