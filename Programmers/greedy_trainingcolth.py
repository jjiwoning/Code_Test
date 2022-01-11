# 탐욕법, 체육복

def solution(n, lost, reserve):
    lost.sort()
    reserve.sort()
    for i in lost:
        if i in reserve:
            reserve.remove(i)
            lost.remove(i)
    for i in lost:
        if i in reserve:
            reserve.remove(i)
        elif i - 1 in reserve:
            reserve.remove(i-1)
        elif i + 1 in reserve:
            reserve.remove(i+1)
        else:
            n -= 1
    return n


n = 5
lost = [2, 4]
reserve = [1, 3, 5]

print(solution(n,lost,reserve))

    

