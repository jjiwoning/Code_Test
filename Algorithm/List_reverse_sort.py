# 리스트의 원소를 역으로 정렬하는 프로그램

def ReverseArray(x):
    n = len(x) # 배열의 길이 저장
    for i in range(n // 2): # 서로 바꾸면서 정렬하기 때문에 2를 나눠줘서 정수로 해둠
        x[i] , x[n - i - 1] = x[n - i -1] , x[i]


if __name__ == '__main__':
    print("배열을 역순으로 정렬하는 프로그램 입니다.")
    index = int(input("배열의 원소 갯수를 입력하세요"))
    x = [None] * index

    for i in range(index):
        x[i] = int(input("x[%d]값을 입력하세요" % i))
    
    ReverseArray(x)
    print("정렬 되었습니다")
    for i in range(index):
        print("x[%d] = %d"%(i , x[i]))