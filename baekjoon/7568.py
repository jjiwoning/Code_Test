import sys

n = int(sys.stdin.readline())
peopleList = []
for i in range(n):
    x, y = map(int, sys.stdin.readline().split())
    peopleList.append((x,y))


for i in peopleList:
    num = 1
    for j in peopleList:
        if i[0] < j[0] and i[1] < j[1]:
            num += 1
    print(num, end = " ")