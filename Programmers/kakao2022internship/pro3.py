
INF = 987654321

def solution(alp, cop, problems):
    maxAlp = 0  # alp가 도달할 최대값
    maxCop = 0  # cop가 도달할 최대값

    for problem in problems:
        maxAlp = max(maxAlp, problem[0])
        maxCop = max(maxCop, problem[1])

    dp = [[INF] * (maxCop + 1) for _ in range(maxAlp + 1)]
    alp = min(alp, maxAlp) # 시작 지점이 maxAlp 보다 큰 경우가 있음
    cop = min(cop, maxCop) # 시작 지점이 maxCop 보다 큰 경우가 있음

    dp[alp][cop] = 0  # 시작 지점

    for i in range(alp, maxAlp + 1):
        for j in range(cop, maxCop + 1):
            if i < maxAlp:
                dp[i + 1][j] = min(dp[i + 1][j], dp[i][j] + 1)
            if j < maxCop:
                dp[i][j + 1] = min(dp[i][j + 1], dp[i][j] + 1)

            for problem in problems:
                if i >= problem[0] and j >= problem[1]: # 문제에서 요구하는 alp, cop보다 큰 경우
                    findAlp = min(i + problem[2], maxAlp) # 학습한 alp가 최대값보다 커질 수 있어 리미트 걸기
                    findCop = min(j + problem[3], maxCop) # 학습한 cop이 최대값보다 커질 수 있어 리미트 걸기
                    dp[findAlp][findCop] = min(dp[findAlp][findCop], dp[i][j] + problem[4])


    return dp[maxAlp][maxCop]

