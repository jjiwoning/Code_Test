# 백준 2143 두 배열의 합

import sys

t = int(sys.stdin.readline())
n = int(sys.stdin.readline())
nArr = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
mArr = list(map(int, sys.stdin.readline().split()))

nAns = []
mAns = []

for i in range(n):
    temp = 0
    for j in range(i, n):
        temp += nArr[j]
        nAns.append(temp)
    
for i in range(m):
    temp = 0
    for j in range(i, m):
        temp += mArr[j]
        mAns.append(temp)

nAns.sort()
mAns.sort(reverse = True)

cnt = 0
nIdx = 0
mIdx = 0
sum = 0

while True:
    currentN = nAns[nIdx]
    target = t - currentN

    if(mAns[mIdx] == target):
        cntA = 0
        cntB = 0
        while nIdx < len(nAns) and nAns[nIdx] == currentN:
            cntA += 1
            nIdx += 1
        while mIdx < len(mAns) and mAns[mIdx] == target:
            cntB += 1
            mIdx += 1
        cnt += (cntA * cntB)
    elif mAns[mIdx] > target:
        mIdx += 1
    else:
        nIdx += 1
    
    if(nIdx == len(nAns) or mIdx == len(mAns)):
        break

print(cnt)