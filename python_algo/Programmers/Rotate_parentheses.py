from collections import deque

def solution(s):
    answer = 0
    q = deque()
    for i in s:
        q.append(i)

    for i in range(len(s)):
        if i > 0:
            a = q.popleft() 
            q.append(a)
        
        stack = []
        check = True

        for i in q:
            if i == "[":
                stack.append(i)
            if i == "{":
                stack.append(i)
            if i == "(":
                stack.append(i)

            if i in "]})":
                if not stack:
                    check = False
                    break

            if i == "]":
                if stack[-1] == "[":
                    stack.pop()
                else:
                    break
            if i == "}":
                if stack[-1] == "{":
                    stack.pop()
                else:
                    break
            if i == ")":
                if stack[-1] == "(":
                    stack.pop()
                else:
                    break

        if not stack and check:
            answer += 1
            
    
    return answer

print(solution("}}}"))