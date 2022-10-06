import itertools


def check(userId, banId):
    if len(userId) != len(banId):
        return False
    else:
        for i, j in zip(userId, banId):
            if i != j:
                if j == '*':
                    continue
                else:
                    return False
        return True


def solution(user_id, banned_id):
    answer = []

    for i in itertools.permutations(user_id, len(banned_id)):
        cnt = 0
        for a, b in zip(i, banned_id):
            if check(a, b):
                cnt += 1

        if cnt == len(banned_id):
            if set(i) not in answer:
                answer.append(set(i))

    return len(answer)


print(solution(["frodo", "fradi", "crodo", "abc123", "frodoc"], ["fr*d*", "abc1**"]))