# 탐욕법, 체육복
# 놓친 부분 : 정렬이 되어 있었어야한다. -> 정렬을 해줌
# lost와 reserve에 같은 원소가 있을 때 제거 작업을 해줘야 된다. -> 제거하는 작업 수행
# 그 다음 원래의 코드대로 수행.
# 다른 사람의 풀이를 보면 set을 사용해서 중복처리를 함. -> 알아두면 좋을듯 set에 대한 공부와 set관련 매서드 확인하기

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

    

