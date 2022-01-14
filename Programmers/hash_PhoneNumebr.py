# 해시 전화번호 목록

# def solution(phone_book):
#     phone_book.sort()
#     for i in range(len(phone_book) - 1):
#         if (phone_book[i] in phone_book[i+1]) or (phone_book[i+1] in phone_book[i]) or(phone_book[i] == phone_book[i + 1]):
#             return False
#     return True

def solution(phone_book):
    phone_book.sort()
    for i in range(len(phone_book) - 1):
        if phone_book[i].startswith(phone_book[i+1]) or phone_book[i+1].startswith(phone_book[i]):
            return False
    return True

# 파이썬의 startswitch 함수는 문자열이 특정 문자로 시작하는지를 알려주는 함수이다.
