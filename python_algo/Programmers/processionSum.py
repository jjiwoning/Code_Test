# 행렬의 합 구하기

def solution(arr1, arr2):
    answer = [[None for i in range(len(arr1[0]))]for j in range(len(arr1))]
    for i in range(len(arr1)):
        for j in range(len(arr1[i])):
            answer[i][j] = arr1[i][j] + arr2[i][j]
    return answer

a1 = [[1],[2]]
a2 =[[3],[5]]
ans = solution(a1, a2)
print(ans)
