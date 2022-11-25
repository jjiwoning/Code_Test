T = int(input())

for test_case in range(1, T + 1):
    n = int(input())
    if n % 2 == 0:
        answer = "Alice"
    else:
        answer = "Bob"

    print("#" + str(test_case) + " " + answer)