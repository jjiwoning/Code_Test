# 하샤드 수 찾기
def solution(x):
    strNum = list(str(x))
    findNum = 0
    for i in range(len(strNum)):
        findNum += int(strNum[i])
    if x % findNum == 0:
        return True
    else:
        return False

# 테스트 돌리기

num = 123
print(solution(num))