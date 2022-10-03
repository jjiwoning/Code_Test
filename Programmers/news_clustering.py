#프로그래머스 뉴스 클러스터링

def solution(str1, str2):
    set1 = makeSet(str1)
    set2 = makeSet(str2)
    
    a1 = set1.copy()
    a2 = set1.copy()

    for i in set2:
        if i not in a1:
            a2.append(i)
        else:
            a1.remove(i)
    
    interSet = []

    for i in set2:
        if i in set1:
            set1.remove(i)
            interSet.append(i)

    if len(a2) == 0:
        return 65536

    answer = len(interSet) / len(a2)
    return int(answer * 65536)

def makeSet(string):
    findSet = list()
    for i in range(len(string) - 1):
        s = string[i : i + 2]

        if " " in s:
            continue

        if s.isalpha():
            s = s.lower()
            findSet.append(s)
    return findSet

a = solution("aa1+aa2", "AAAA12")
print(a)