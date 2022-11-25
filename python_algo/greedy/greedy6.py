n = int(input())

ls = list(map(int, input().split()))

answer = [0] * 8

for i in range(n):
    for j in range(n):
        if ls[i] == 0 and answer[j] == 0:
            answer[j] = i + 1
            break
        elif answer[j] == 0:
            ls[i] -= 1

for x in answer:
    print(x, end = " ")


