# 곱하기 또는 더하기

import sys

s = sys.stdin.readline().rstrip()

ans = int(s[0])

for i in range(1, len(s)):
    num = int(s[i])
    if ans <= 1 or num <= 1:
        ans += num
    else:
        ans *= num

print(ans)