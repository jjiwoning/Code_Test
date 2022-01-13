# 프로그래머스 해시, 완주하지 못한 선수

def solution(participant, completion):
    dic = {}
    hashValue = 0
    for i in participant:
        dic[hash(i)] = i
        hashValue += hash(i)
    for j in completion:
        hashValue -= hash(j)
    return dic[hashValue]

part = ["mislav", "stanko", "mislav", "ana"]
comp = ["stanko", "ana", "mislav"]
print(solution(part,comp))