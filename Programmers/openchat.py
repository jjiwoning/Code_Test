#오픈채팅방

def solution(record):
    userDict = {}
    answer = []
    for i in record:
        userList = list(i.split())
        if userList[0] == "Enter":
            userDict[userList[1]] = userList[2]
            answer.append("%s님이 들어왔습니다." %userList[1])
        elif userList[0] == "Leave":
            answer.append("%s님이 나갔습니다." %userList[1])
        else:
            userDict[userList[1]] = userList[2]
    
    for i in range(len(answer)):
        a, b = answer[i].split()
        a = a[:-2]
        answer[i] = answer[i].replace(a, userDict[a])

    return answer


record = ["Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"]

print(solution(record))
