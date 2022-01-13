# 프로그래머스, 그리디, 큰 수 만들기

# 틀린 풀이) 조합으로 문제를 풀면 상당히 오래 걸림
# from itertools import combinations

# def solution(number, k):
#     numList = list(combinations(number , len(number) -k))
#     numList.sort()
#     max = ''.join(numList[-1])
#     return max

# 풀이: 스택을 활용하여 스택의 마지막 값과 넣을 num 값을 비교한다. 
# 그 다음 num 값이 가장 커지는 경우까지 스택을 pop해서 비워준다. 
# 그 다음 num 값을 스택에 푸시한다.
# 생각해야 되는 풀이 : 앞에서부터 가장 큰 값을 넣어야 하는구나 
def solution(number, k):
    # 스택을 먼저 선언
    stack = []
    # 루프 돌기
    for num in number:
        # pop을 하는 조건을 만족할 때 pop하기
        # 조건 1 : 스택에 뭐가 있어야됨
        # 조건 2 : 값을 k번 만 빼야됨 -> k가 0보다 커야 된다.
        # 조건 3 : 스택의 마지막이 num 보다 작아야됨
        while stack and k > 0 and stack[-1] < num:
            #이 경우 pop을 하고, pop을 했기 때문에 k가 1이 감소 되어야 한다.
            stack.pop()
            k -= 1
        # pop 하는 조건이 아닐 때는 값을 넣어줘야 한다.        
        stack.append(num)
    # answer는 number의 길이 - k만큼 슬라이싱 해준다.
    # -> 슬라이싱은 index 바깥으로 나가도 괜찮음! 
    # 일반적으로 k는 0일텐데 ex) k = 3 number = 1000000 이런 경우엔 k는 처음 인풋받은 그대로 유지됨
    # 이럴 때 답은 뒷 숫자를 k개만큼 없애준 1000 이므로 슬라이싱을 len(number) - k로 해주는 것    
    return ''.join(stack[:len(number)-k])

number = "1231234"
k = 3
print(solution(number, k))