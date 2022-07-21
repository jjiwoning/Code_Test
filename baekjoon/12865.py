# 백준 12865 평범한 배낭

import sys

n, k = map(int, sys.stdin.readline().split())

thing = [[0,0]]
d = [[0] * (k + 1) for i in range(n + 1)]

for i in range(n):
    thing.append(list(map(int, sys.stdin.readline().split())))

for i in range(1, n+1):
    for j in range(1, k+1):
        w = thing[i][0] # 물건의 무게
        v = thing[i][1] # 물건의 가치

        if j < w: # j라는 무게로 w의 무게를 가지는 물건을 넣지 못하는 경우
            d[i][j] = d[i - 1][j] # 내 앞 물건에 해당하는 값을 가져온다.
        else:
            d[i][j] = max( v + d[i - 1][j - w], d[i - 1][j])
    
print(d[n][k])

