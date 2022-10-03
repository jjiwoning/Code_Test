def solution(n):

    if n == 1 or n == 2:
        return n

    jump = [0] * (n + 1)
    jump[1] = 1
    jump[2] = 2
    for i in range(3, n + 1):
        jump[i] = jump[i - 2] + jump[i - 1]
    return jump[n] % 1234567

print(solution(1))