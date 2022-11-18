import itertools


def solution(n, k, t, arr):
    answer = 0

    for i in range(k, n + 1):
        ls = list(itertools.combinations(arr, i))
        for j in ls:
            if sum(j) <= t:
                answer += 1

    return answer


i = solution(5, 3, 11, [2, 5, 3, 8, 1])
print(i)
