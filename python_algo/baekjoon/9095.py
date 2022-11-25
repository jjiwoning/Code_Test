import sys

n = int(sys.stdin.readline())

for i in range(n):
    find = int(sys.stdin.readline())
    if find <= 3:
        print(2**(find-1))
        continue
    d = [0] * (find + 1)
    d[1] = 1
    d[2] = 2
    d[3] = 4
    for i in range(4, len(d)):
        d[i] = d[i - 1] + d[i - 2] + d[i - 3]
    
    print(d[find])