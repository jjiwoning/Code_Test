def solution(board, moves):
    answer = 0
    toy = []
    for i in moves:
        i = i-1
        for j in range(len(board)):
            if board[j][i] != 0:
                toy.append(board[j][i])
                board[j][i] = 0
                if len(toy) > 1:
                    if toy[-1] == toy[-2]:
                        toy.pop()
                        toy.pop()
                        answer += 2
                    break
                else:
                    break
               
    return answer


print(solution([[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]],[1,5,3,5,1,2,1,4]))