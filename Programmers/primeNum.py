# 소수 찾기
# 1. 2를 제외한 짝수는 무조건 소수일 수 없다.
# 2. 모든 약수가 가운데 약수를 기준으로 곱셈 연산에 대해 대칭을 이룬다.
# -> 구하려는 수의 제곱근(중앙에 위치하는 수)의 범위까지만 나누어지는지 확인하면 된다.

# 제곱근 연산을 해주는 함수 : math 라이브러리의 sqrt 함수 이용

import math

def solution(n):
    answer = []
    if n == 2:
        return 1
    if n == 3:
        return 2
    if n == 5:
        return 3

    for i in range(5, n, 2):
        if all(i % j != 0 for j in range(2, int(math.sqrt(i)) + 1)):
            answer.append(i)
    return len(answer) + 2

# 위 문제는 좋지 않은 풀이인거 같다.
# 에라토스테네스의 채를 사용한 풀이