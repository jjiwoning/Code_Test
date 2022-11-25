# 백준 13305 주유소

import sys

def solution(city, meter, price):
    answer = 0
    i = 0
    while i < city - 1:
        if price[i] <= price[i + 1]:
            price[i + 1] = price[i]
        answer += meter[i] * price[i]
        i += 1
    return answer

city = int(sys.stdin.readline())
meter = list(map(int, sys.stdin.readline().split()))
price = list(map(int, sys.stdin.readline().split()))

print(solution(city, meter, price))