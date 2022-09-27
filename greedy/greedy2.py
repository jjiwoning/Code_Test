n = int(input())

ls = []

for i in range(n):
    ls.append(tuple(map(int, input().split())))

ls.sort(reverse = True)

max = 0
answer = 0

for i in ls:
    if i[1] > max:
        max = i[1]
        answer += 1

print(answer)