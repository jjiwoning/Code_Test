# 거리두기 확인하기

def solution(places):
    answer = []
    for i in range(5):
        place = places[i]
        person = []
        ans = 1
        for i in range(5):
            for j in range(5):
                if place[i][j] == 'P':
                    person.append([i,j])
        for i in range(len(person)):
            for j in range(len(person)):
                if i != j and (abs(person[i][0] - person[j][0]) + abs(person[i][1] - person[j][1])) <= 2:
                    if (person[i][0] + person[j][0]) % 2 == 1:
                        if place[person[i][0]][person[j][1]] != 'X' or place[person[j][0]][person[i][1]] != 'X':
                            ans = 0
                    else:
                        if place[(person[i][0] + person[j][0])//2][(person[i][1] + person[j][1])//2] != 'X':
                            ans = 0
        answer.append(ans)                 
    return answer

a = [["POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"], ["POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"], ["PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"], ["OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"], ["PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"]]
print(solution(a))
