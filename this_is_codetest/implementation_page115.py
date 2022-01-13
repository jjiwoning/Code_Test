# 구현, 왕실의 나이트
now = input()

changeNum = {'a':1, 'b':2, 'c':3, 'd':4, 'e':5, 
'f':6, 'g':7, 'h':8}

x = changeNum[now[0]]
y = int(now[-1])
canMove = [(-2, -1), (-2, 1), (2, -1), (2, 1), (-1, -2)
,(-1, 2), (1, -2), (1, 2)]

move = 0

for i in canMove:
    moveX = x + i[0]
    moveY = y + i[-1]
    if moveX >= 1 and moveX <= 8 and  moveY >= 1 and moveY <= 8:
        move += 1

print(move)