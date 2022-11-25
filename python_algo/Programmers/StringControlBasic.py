# 문자열 다루기 기본
# isdigit 함수를 사용하면 더욱 더 편리하게 풀 수 있는 문제

def solution(s):
    if len(s) == 4 or len(s) == 6:
        s = list(s)
        num = ['1', '2', '3', '4', '5', '6', '7', '8', '9', '0']
        for i in s:
            if i not in num:
                return False
        
        return True
    
    return False
    
    


s = "a234"

print(solution(s))