def solution(n):

    if n == 2 or n == 3:
        return 1


    fibo = [0] * (n + 1)
    fibo[0] = 0
    fibo[1] = 1
    fibo[2] = 1

    for i in range(3, n + 1):
        fibo[i] = fibo[i - 1] + fibo[i - 2]

    return fibo[n] % 1234567
