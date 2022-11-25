# 숫자 문자열과 영단어
def solution(s):
    s = str(s)
    #dic = {'zero':'0', 'one':'1', 'two':'2', 'three':'3', 'four':'4', 'five':'5', 'six':'6', 'seven':'7', 'eight':'8', 'nine':'9'}
    alphaList = ['zero', 'one', 'two', 'three', 'four', 'five', 'six', 'seven', 'eight', 'nine']
    for i in alphaList:
        if i in s:
            if i == 'zero':
                s = s.replace('zero', '0')
            elif i == 'one':
                s = s.replace('one','1')
            elif i == 'two':
                s = s.replace('two','2')
            elif i == 'three':
                s = s.replace('three','3')
            elif i == 'four':
                s = s.replace('four','4')
            elif i == 'five':
                s = s.replace('five','5')
            elif i == 'six':
                s = s.replace('six','6')
            elif i == 'seven':
                s = s.replace('seven','7')
            elif i == 'eight':
                s = s.replace('eight','8')
            elif i == 'nine':
                s = s.replace('nine','9')
    
    answer = int(s)
    return answer