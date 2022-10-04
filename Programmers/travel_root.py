from audioop import reverse


def solution(tickets):
    answer = []
    dic = {}
    
    for s, e in tickets:
        dic[s] = dic.get(s, []) + [e]

    for i in dic.keys():
        dic[i].sort(reverse = True)

    start = ["ICN"]
    path = []

    while start:
        top = start[-1]

        if top not in dic or len(dic[top]) == 0:
            path.append(start.pop())
        else:
            start.append(dic[top][-1])
            dic[top].pop()

    answer = path[::-1]
    return answer