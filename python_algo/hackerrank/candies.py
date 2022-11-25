def candies(n, arr):
    answer = [1]
    candy = 1
    before = arr[0]

    for i in range(1, len(arr)):
        if arr[i] > before:
            candy += 1
            answer.append(candy)
        elif arr[i] <= before:
            candy = 1
            answer.append(candy)
    
        before = arr[i]
    
    for i in range(n - 2, -1, -1):
        if answer[i] <= answer[i + 1] and arr[i] > arr[i + 1]:
            answer[i] = answer[i + 1] + 1
    
    return sum(answer)

print(candies(10, [2, 4, 2, 6, 1, 7, 8, 9, 2, 1]))