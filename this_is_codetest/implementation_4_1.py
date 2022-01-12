# 상하좌우
import sys

n = int(input())
move = list(map(str, input().split()))

nowX = 1
nowY = 1

for i in move:
    if i == 'R':
        if nowY == n:
            pass
        else:
            nowY += 1
    if i == 'L':
        if nowY == 1:
            pass
        else:
            nowY -= 1
    if i == 'U':
        if nowX == 1:
            pass
        else:
            nowX -= 1
    if i == 'D':
        if nowX == n:
            pass
        else:
            nowX +=1

print(nowX,nowY)
