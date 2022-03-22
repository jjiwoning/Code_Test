# 뒤집기

s = input()
ls = list(s)

key = ls[0]
ans = [ls[0]]

for i in range(1, len(ls)):
    if ls[i] != key:
        key = ls[i]
        ans.append(ls[i])

answer = min(ans.count('0'), ans.count('1'))

print(answer)