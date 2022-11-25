# 전자레인지

sec = int(input())

a = 300
b = 60
c = 10

aCnt = 0
bCnt = 0
cCnt = 0

if sec % 10 != 0:
    print(-1)
else:
    aCnt = sec // a
    sec = sec % a
    bCnt = sec // b
    sec = sec % b
    cCnt = sec // c
    sec = sec % c
    print(aCnt, bCnt, cCnt)
        
