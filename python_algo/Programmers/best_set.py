def solution(n, s):
    answer = []
    if n > s:
        return [-1]
    find = s // n
    for i in range(n):
        answer.append(find)
    idx = n - 1
    for _ in range(s % n):
        answer[idx] += 1
        idx -= 1
    return answer