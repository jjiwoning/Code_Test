def solution(k, dungeons):
    answer = [0]
    checked = [False] * len(dungeons)

    def dfs(level, k):

        if level > answer[0]:
            answer[0] = level

        for i in range(len(dungeons)):
            if checked[i] == False and k >= dungeons[i][0]:
                checked[i] = True
                dfs(level + 1, k - dungeons[i][1])
                checked[i] = False

    dfs(0, k)

    return answer[0]

