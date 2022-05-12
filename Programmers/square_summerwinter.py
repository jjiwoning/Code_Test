import math

def solution(w,h):
    
    answer = w * h

    if w == h:
        answer -= w
    else:
        a = math.gcd(w, h)
        w1 = w // a
        h1 = h // a
        answer -= (w1 + h1 - 1) * a

    return answer

