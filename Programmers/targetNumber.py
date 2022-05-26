# 타겟 넘버
from collections import deque

def solution(numbers, target):
    answer = 0
    queue = deque()
    queue.append(0)
    for i in numbers:
        list1 = []
        for _ in range(len(queue)):
            list1.append(queue.popleft())
        for j in list1:
            queue.append(j + i)
            queue.append(j - i)
        
    answer = queue.count(target)
    return answer

print(solution([1, 1, 1, 1, 1], 3))

# 다른 사람의 풀이 -> 내 풀이와 비슷한데 더 깔끔하고 낭비 없이 풀었다.
def solution2(numbers, target):
    answer = 0
    queue = deque()
    queue.append(0)
    for i in numbers:
        list1 = []
        for _ in range(len(queue)):
            x = queue.pop()
            list1.append(x + i)
            list1.append(x - i)
        queue = list1.copy()
    answer = queue.count(target)
    return answer