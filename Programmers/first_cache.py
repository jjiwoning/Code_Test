from collections import deque

def solution(cacheSize, cities):
    answer = 0
    cache = deque()

    if cacheSize == 0:
        return len(cities) * 5

    for i in cities:

        i = i.lower()

        if len(cache) < cacheSize:
            if i not in cache:
                cache.append(i)
                answer += 5
            else:
                cache.remove(i)
                cache.append(i)
                answer += 1
            continue

        if i in cache:
            cache.remove(i)
            cache.append(i)
            answer += 1
        else:
            cache.popleft()
            cache.append(i)
            answer += 5

    return answer

print(solution(2, ["a", "a", "a", "b", "b", "b", "c", "c", "c"]))