#자릿수 더하기

def solution(n):
    nList = list(map(int, str(n)))
    answer = 0
    
    for i in nList:
        answer += int(i)
    
    return answer