from collections import deque


def solution(queue1, queue2):
    answer = 0
    queue1 = deque(queue1)
    queue2 = deque(queue2)

    queue1Sum = sum(queue1)
    queue2Sum = sum(queue2)

    queueLength = len(queue1) * 4

    if (queue1Sum + queue2Sum) % 2 == 1:
        return -1

    while not(queue1Sum == queue2Sum):
        if queue1Sum > queue2Sum:
            element = queue1.popleft()
            queue2.append(element)
            queue1Sum -= element
            queue2Sum += element
            answer += 1
        else:
            element = queue2.popleft()
            queue1.append(element)
            queue2Sum -= element
            queue1Sum += element
            answer += 1

        if answer > queueLength:
            answer = -1
            break

    return answer

