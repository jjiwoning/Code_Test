# 뒤집기 -> 이것이 코딩테스트다 p508과 같은 문제

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