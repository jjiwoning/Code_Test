def solution(routes):
    answer = 1
    routes.sort(key = lambda x : x[1])
    camera = routes[0][1]

    for i in range(1, len(routes)):
        if camera < routes[i][0]:
            camera = routes[i][1]
            answer += 1
            
    return answer