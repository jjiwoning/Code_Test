#수박수박수박?

def solution(n):
    # 메모리 할당이 커지는 단점 존재
    answer = "수박" * 5000
    answer = answer[:n]
    return answer