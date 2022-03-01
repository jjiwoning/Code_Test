# 1로 만들기

# 다이나믹 프로그래밍의 대표적인 문제이다.
# 바텀업 다이나믹 프로그래밍으로 풀면 좋다.

x = int(input())

d = [0] * 30001

for i in range(2, x + 1):

    d[i] = d[i - 1] + 1

    if i % 2 == 0:
        d[i] = min(d[i], d[i // 2] + 1)
    
    if i % 3 == 0:
        d[i] = min(d[i], d[i // 3] + 1)

    if i % 5 == 0:
        d[i] = min(d[i], d[i // 5] + 1)


print(d[x])