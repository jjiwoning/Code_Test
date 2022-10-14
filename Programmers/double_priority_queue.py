import heapq


def solution(operations):
    answer = []
    for i in operations:
        o, num = i.split(" ")
        if o == "I":
            heapq.heappush(answer, int(num))
            continue
        if o == "D":
            if not answer:
                continue
            if num == "1":
                answer.remove(heapq.nlargest(1, answer)[0])
            else:
                heapq.heappop(answer)

    if answer:
        return [heapq.nlargest(1, answer)[0], answer[0]]
    return [0, 0]