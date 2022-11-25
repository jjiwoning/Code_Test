# 정수 제곱근 판별하기

def solution(n):
    num = n ** 0.5
    if num == int(num):
        return (num+1)**2
    else:
        return -1


x = 121
y = solution(x)
print(y)