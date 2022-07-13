# 백준 1339 단어 수학

import sys

n = int(sys.stdin.readline())
ls = [] # 단어 담는 리스트
answer = [] # 정답 찾을 리스트
for i in range(n):
    ls.append(sys.stdin.readline().rstrip())

alphaDict = {}

for i in range(n):
    for j in range(len(ls[i])):
        if ls[i][j] in alphaDict:
            alphaDict[ls[i][j]] += 10 ** (len(ls[i]) - j - 1)
        else:
            alphaDict[ls[i][j]] = 10 ** (len(ls[i]) - j - 1)

for i in alphaDict.values():
    answer.append(i)

answer.sort(reverse = True)

ans = 0
k = 9
for i in answer:
    ans += i * k
    k -= 1

print(ans)