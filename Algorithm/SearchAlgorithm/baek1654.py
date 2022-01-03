# 백준 1654번 랜선 자르기

import sys

n , wantedNum = map(int, sys.stdin.readline().split())
l = [None] * n
for i in range(n):
    l[i] = int(sys.stdin.readline())

start = 1
last = max(l)
while start <= last:
    n = 0
    mid = (start+last) // 2
    for i in l:
        n += i // mid
    
    if n >= wantedNum:
        start = mid + 1
    elif n < wantedNum:
        last = mid - 1
    
print(last)

# 최대한의 길이를 찾아야하기 때문에 이분 탐색이 끝날때 까지 돌아가야 한다
# 즉 mid를 찾은 순간의 값이 아닌 start > last가 되는 순간의 last값이 최대 값이 된다.