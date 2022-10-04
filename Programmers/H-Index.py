def solution(citations):
    answer = 0
    citations.sort(reverse = True)
    length = len(citations)
    for i in range(length):
        if i + 1 <= citations[i]:
            answer = i + 1
        else:
            break

    return answer