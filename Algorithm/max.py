# 원소의 최대값 구하기

def Max_Of(a):
    maximum = a[0]
    for i in range(1, len(a)): # a[0]는 이미 맥스로 판별, len(a)-1 이 최대 index이기 때문
        if a[i] > maximum:
            maximum = a[i]
    return maximum

 # 재사용 할 수 있는 모듈로 만들기 위해 넣은 코드 나중에 이 코드를 다른 곳에서 import 하더라도 아래의 코드는 실행 안됨
if __name__ == '__main__': 
    print("배열의 원소 최대값을 구하는 프로그램 입니다.")
    num = int(input("배열의 원소 수를 입력하세요:"))
    x = [None]*num #원소 값을 정하지 않고 리스트를 생성 방법 -> 원소의 갯수는 num 원소의 값은 NULL
    
    for i in range(num):
        x[i] = int(input("x[%d] 값을 넣어주세요" %i))
    
    maxNum = Max_Of(x)
    print("최대값은 %d 입니다" %maxNum)