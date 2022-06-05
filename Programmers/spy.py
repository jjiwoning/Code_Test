# 프로그래머스 위장 -> 해시

from itertools import combinations


def solution(clothes):
    clothDict = {}
    key = []
    answer = 1

    for i in clothes:
        key.append(i[1])

    key = list(set(key))

    for i in key:
        clothDict[i] = 0
    for i in clothes:
        clothDict[i[1]] += 1
    

    for i in key:
        answer *= (clothDict[i] + 1)


    # keyComb = []
    # for i in range(1, len(key) + 1):
    #     keyComb += list(combinations(key, i))

    # for i in keyComb:
    #     cnt = 1
    #     for j in i:
    #         cnt *= clothDict[j]
    #     answer += cnt

    return answer - 1

print(solution([["crowmask", "face"], ["bluesunglasses", "face"], ["smoky_makeup", "face"]]))