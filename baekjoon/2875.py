# 대회 or 인턴

import sys

n, m, k = map(int, sys.stdin.readline().split())

result = 0

while n >= 2 and m >= 1 and n+m >= k + 3:
    # 여학생은 2명 이상, 남학생은 1명 이상, 여학생 + 남학생의 수가 k보다 3명 많아야 팀 결성 가능
    n -= 2
    m -= 1
    result += 1

print(result)