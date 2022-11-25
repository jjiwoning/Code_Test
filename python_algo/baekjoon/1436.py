import sys

n = int(sys.stdin.readline())

numList = []

for i in range(1, 3000000):
    strI = str(i)
    if "666" in strI:
        numList.append(i)

print(numList[n-1])