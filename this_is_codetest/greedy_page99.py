# 1이 될 때까지
import sys
# 내가 푼 코드
n, k = map(int,sys.stdin.readline().split())
num = 0
while True:
    if n%k ==0:
        n = n/k
        num = num + 1
    else:
        n = n - 1
        num = num + 1
    if n == 1:
        break

print(num)