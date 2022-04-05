# 124 나라의 숫자

# 1, 2, 4 로 표현이 된다. -> 3진수라고 볼 수 있다.

def solution(n):
    numDict = {'1' : '1', '2' : '2', '3' : '4'}
    answer = []
    while n > 0:
        a = n % 3
        if a == 0:
            answer.append('4')
            n = n // 3 - 1
        else:
            answer.append(numDict[str(a)])
            n = n // 3
    answer.reverse()
    answer = ''.join(answer)
    return answer

print(solution(12304))
