# 가운데 글자 가져오기
def solution(s):
    if len(s) % 2 == 1:
        mid = len(s) // 2
        return s[mid]
    else:
        mid = len(s) // 2
        return s[mid-1 : mid + 1]

s = "qwer"
solution(s)