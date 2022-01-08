# n을 나눠서 나머지가 1이 되는 최소 숫자 x 찾기

def solution(n):
    for i in range(1,n):
        if n%i == 1:
            answer = i
            break
    
    return answer


x = 10
print(solution(x))
