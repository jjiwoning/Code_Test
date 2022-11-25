# 문자열 내 마음대로 정렬하기

# 람다를 이용한 정렬에 대해서 공부를 할 필요가 있다.

def solution(strings, n):
    strings.sort(key = lambda x : (x[n], x))
    return strings

