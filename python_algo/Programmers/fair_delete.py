def solution(s):
    if len(s) % 2 == 1:
        return 0

    stack = []

    for i in s:
        if stack == []:
            stack.append(i)
            continue
        if stack[-1] == i:
            stack.pop()
            continue
        stack.append(i)
    
    if stack == []:
        return 1
    else:
        return 0

print(solution("baabaa"))