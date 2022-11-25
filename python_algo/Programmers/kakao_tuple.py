def solution(s):
    answer = set()
    result = []
    srcs = s[2:-2].split('},{')
    srcs.sort(key=lambda x : len(x))
    for src in srcs:
        temp = set(list(map(int, src.split(','))))
        result = result + list(set.difference(temp, answer))
        answer=temp

    return result

print(solution("{{2},{2,1},{2,1,3},{2,1,3,4}}"))