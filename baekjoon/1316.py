# 그룹 단어 체커

import sys

n = int(sys.stdin.readline())
strList = []
for i in range(n):
    strList.append(sys.stdin.readline().rstrip())

ans = 0

for s in strList:
    stack = []
    tf = True
    for c in s:
        if c in stack and c != stack[-1]:
            tf = False
            break
        stack.append(c)
    if tf == True:
        ans += 1

print(ans)