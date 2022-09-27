n = int(input())

ls = list(map(int, input().split()))

cnt = int(input())

hash = [0] * 101

maxH = -1
minH = 101

for i in ls:
    hash[i] += 1
    if maxH < i : maxH = i
    if minH > i : minH = i

for i in range(cnt):
    if hash[maxH] == 1:
        hash[maxH] -= 1
        maxH -= 1
        hash[maxH] += 1
    else:
        hash[maxH] -= 1
        hash[maxH - 1] += 1
    
    if hash[minH] == 1:
        hash[minH] -= 1
        minH += 1
        hash[minH] += 1
    else:
        hash[minH] -= 1
        hash[minH + 1] += 1

print(maxH - minH)
