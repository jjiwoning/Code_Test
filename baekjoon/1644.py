def findPrimeNum(n):
    if n <= 1:
        return []
    primeList = []
    num = [True] * (n + 1)
    for i in range(2, int(n**(0.5)) + 1):
        if num[i] == True:
            j = 2
            while i * j <= n:
                num[i * j] = False
                j += 1
    for i in range(2, n + 1):
        if num[i]:
            primeList.append(i)
    return primeList

def sol(n):
    end = 0
    primeNumbers = findPrimeNum(n)
    answer = 0
    cnt = 0
    for start in range(len(primeNumbers)):
        while answer < n and end < len(primeNumbers):
            answer += primeNumbers[end]
            end += 1
        if answer == n:
            cnt += 1
        answer -= primeNumbers[start]
    return cnt

n = int(input())
print(sol(n))

