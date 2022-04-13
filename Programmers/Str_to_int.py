#문자열 정수로 바꾸기

def solution(s):
    if s[0] == '-':
        s = s[1:]
        s = int(s)
        return s * (-1)
    elif s[0] == '+':
        s = s[1:]
        return int(s)
    else:
        return int(s)
  