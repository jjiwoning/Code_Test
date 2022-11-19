T = int(input())

for test_case in range(1, T + 1):
    n = int(input())
    building = list(map(int, input().split()))

    answer = 0

    for i in range(2, n - 2):
        left1 = building[i] - building[i - 2]
        left2 = building[i] - building[i - 1]
        right1 = building[i] - building[i + 1]
        right2 = building[i] - building[i + 2]
        if left1 > 0 and left2 > 0 and right1 > 0 and right2 > 0:
            answer += min(left1, left2, right1, right2)

    print("#" + str(test_case) + " " + str(answer))