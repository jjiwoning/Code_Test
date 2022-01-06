# 핸드폰 번호 *로 가리기 뒷 자리 4개 제외
def solution(phone_number):
    strNumber = str(phone_number)
    strNumber = list(strNumber)
    for i in range(len(strNumber[0:-4])):
        strNumber[i] = '*'
    answer = ''.join(strNumber)
    return answer

