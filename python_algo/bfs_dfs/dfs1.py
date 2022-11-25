n = int(input())

check = [0] * n + 1

def dfs(number):
    if number == n + 1:
        for i in range(1, n + 1):
            if check[i] == 1:
                print(i, end = " ")
        print()
    else:
        check[number] = 1
        dfs(number + 1)

        check[number] = 0
        dfs(number + 1)

dfs(1)