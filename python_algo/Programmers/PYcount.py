# 문자열 내 p와 y의 개수

def solution(s):
    pCount = 0
    yCount = 0
    for i in s:
        if i == 'p' or i == 'P':
            pCount += 1
        elif i == 'y' or i == 'Y':
            yCount +=1
    if pCount == yCount:
        return True
    else:
        return False
    
    