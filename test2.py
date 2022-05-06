from collections import deque

def solution(priorities, location):
    stk = deque()
    prior = deque(priorities)
    for i in range(len(priorities)):
        stk.append(i)
    cnt = 0
    while prior:
        maxPrior = max(prior)
        if prior[0] != maxPrior:
            prior.append(prior.popleft())
            stk.append(stk.popleft())
        else:
            prior.popleft()
            a = stk.popleft()
            cnt += 1
            if a == location:
                return cnt

#solution([2, 1, 3, 2], 2)


