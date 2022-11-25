# enumerate 함수를 이용한 리스트 탐색
# enumerate 함수는 인덱스와 원소를 짝지어서 튜플로 꺼내는 내장함수이다.

x = ['i', 'love', 'you', 'too']

for i, name in enumerate(x):
    print("x[%d] = %s" %(i, name))