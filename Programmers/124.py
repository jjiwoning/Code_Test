# 124 나라의 숫자

# 1, 2, 4 로 표현이 된다. -> 3진수라고 볼 수 있다.
# 주의사항) 해당 숫자는 0이 없다. -> 0을 처리하는 방법이 필요함
# 0은 곧 3으로 볼 수 있다.
# 나머지가 0이면 몫에서 1을 빼고 나머지를 3으로 계산하는 방법으로 처리 -> 문제에서 핵심 알고리즘

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
