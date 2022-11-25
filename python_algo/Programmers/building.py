def solution(board, skill):
    answer = 0

    for i in skill:
        dx = i[1]
        dy = i[2]
        nx = i[3]
        ny = i[4]
        casting = i[5]
        if i[0] == 1:
            for j in range(dx, nx + 1):
                for k in range(dy, ny + 1):
                    board[j][k] -= casting

        if i[0] == 2:
            for j in range(dx, nx + 1):
                for k in range(dy, ny + 1):
                    board[j][k] += casting

    for i in board:
        for j in i:
            if j > 0:
                answer += 1

    return answer


board = [[1,2,3],[4,5,6],[7,8,9]]
skill = [[1,1,1,2,2,4],[1,0,0,1,1,2],[2,2,0,2,0,100]]
solution(board, skill)