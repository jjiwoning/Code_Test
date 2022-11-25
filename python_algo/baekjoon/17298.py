# 오큰수

from collections import deque
import sys

n = int(sys.stdin.readline())

numList = list(map(int, sys.stdin.readline().split()))

stack = []
sol = [-1] * n

for i in range(n):
    while stack and numList[stack[-1]] < numList[i]:
        sol[stack.pop()] = numList[i]
    stack.append(i)

print(*sol)









#------------------- 틀린 풀이 (시간 초과)--------------------
# n = int(sys.stdin.readline())

# list1 = list(map(int, sys.stdin.readline().split()))

# list2 = deque(list1)

# maxNum = max(list1)

# nge = []

# for i in range(len(list1) - 1):
#     a = list1[i]
#     list2.popleft()
#     for j in range(len(list2)):
#         if a < list2[j]:
#             findNum = list2[j]
#             nge.append(findNum)
#             break
#         if a == maxNum:
#             nge.append(-1)
#             break

# nge.append(-1)


# for i in nge:
#     print(i, end = ' ')