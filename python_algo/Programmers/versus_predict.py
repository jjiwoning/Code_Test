def solution(n,a,b):
    answer = 1

    while True:

        if a > b:
            a, b = b, a

        if a % 2 == 1:
            a += 1
        if b % 2 == 1:
            b += 1
        
        if a == b:
            break

        a = a/2
        b = b/2
        answer += 1

        if a + 1 == b:
            if a % 2 == 1:
                break
            else:
                continue

        if answer > n//2:
            answer = n//2
            break

    return answer

print(solution(8, 4, 7))