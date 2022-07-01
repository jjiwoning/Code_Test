from itertools import combinations
import sys

def sol(l, c, charList):
    answer = [] 
    aeiou = ['a', 'e', 'i', 'o', 'u'] # 모음 리스트
    charList.sort() # 미리 문자열 정렬 -> 답이 정렬된 조합으로 나와야되기 때문에

    for i in combinations(charList, l):
        cnt = 0 # 모음 갯수 카운트하기
        for j in i: # 문자열의 문자 하나 하나 모음인지 검사하기
            if j in aeiou: # 문자열의 문자가 모음인 경우
                cnt += 1 # 모음 갯수++
        if cnt >= 1 and l >= cnt + 2: # 모음 갯수 1개 이상 + 자음 갯수 2개 이상인 경우
            k = ''.join(i) # 리스트 -> 문자열로 변환하는 방법
            answer.append(k) # answer 값에 포함
    return answer # 해당 리스트 리턴

l, c = map(int, sys.stdin.readline().split())
charList = list(map(str, sys.stdin.readline().split()))
answer = sol(l, c, charList)
for i in answer:
    print(i)
