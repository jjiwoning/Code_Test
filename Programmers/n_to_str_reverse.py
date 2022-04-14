# 자연수 뒤집어 배열로 만들기

def solution(n):
    n = list(str(n))
    answer = []
    for i in range(len(n)):
        a = n.pop()
        answer.append(int(a))
    return answer

# 다른 풀이들
# def digit_reverse(n):
#     return list(map(int, reversed(str(n))))

# def digit_reverse(n):
#     return list(map(int, list(str(n))[::-1]))