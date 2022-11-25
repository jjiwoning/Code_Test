# 로또의 최고 순위와 최저 순위

import sys

def solution(lottos : list, win_nums : list) -> list:
    cnt = lottos.count(0)
    ans = 0
    for i in lottos:
        if i in win_nums:
            ans += 1
    maxAns = ans + cnt
    minAns = ans
    dic = {6 : 1 , 5 : 2, 4 : 3, 3 : 4, 2 : 5, 1 : 6, 0: 6}
    answer = [dic[maxAns], dic[minAns]]
    return answer

#lottos = [44, 1, 0, 0, 31, 25] 
lottos = [0, 0, 0, 0, 0, 0]
win_nums = [31, 10, 45, 1, 6, 19]

print(solution(lottos, win_nums))