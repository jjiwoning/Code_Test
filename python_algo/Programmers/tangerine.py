# 프로그래머스 귤 고르기

def solution(k, tangerine):
    answer = 0
    maximum = max(tangerine)
    tan_list = [0] * (maximum + 1)

    for i in tangerine:
        tan_list[i] += 1

    tan_list.sort(reverse=True)

    for i in tan_list:
        if k <= 0:
            break
        k -= i
        answer += 1

    return answer