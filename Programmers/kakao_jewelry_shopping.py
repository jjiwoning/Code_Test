def solution(gems):
    n = len(gems)

    answer = [0, n - 1]

    start = 0
    end = 0
    kind_of_gem = len(set(gems))

    gem_dict = {gems[0]: 1}

    while start < n and end < n:
        if len(gem_dict) < kind_of_gem:
            end += 1
            if end == n:
                break
            gem_dict[gems[end]] = gem_dict.get(gems[end], 0) + 1
        else:
            if end - start + 1 < answer[1] - answer[0] + 1:
                answer = [start, end]
            if gem_dict[gems[start]] == 1:
                del gem_dict[gems[start]]
            else:
                gem_dict[gems[start]] -= 1
            start += 1

    answer[0] += 1
    answer[1] += 1
    return answer

print(solution(["DIA", "RUBY", "RUBY", "DIA", "DIA", "EMERALD", "SAPPHIRE", "DIA"]))