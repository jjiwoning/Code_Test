#import해서 max of 함수 사용해보기 + 배열 값 랜덤으로 넣어서 돌려보기

import random  # 랜덤 호출
from max import Max_Of # 같은 디렉토리에 있는 max에서 Max_Of 함수 호출

print("난수의 최대값을 구해봅시다.")
num = int(input("난수의 갯수를 입력해주세요"))
low = int(input("난수의 최소값을 입력해주세요"))
high = int(input("난수의 최대값을 입력해주세요"))

x = [None] * num # num개의 원소를 가지는 빈 리스트 생성

for i in range(num):
    x[i] = random.randint(low, high) # randint(a, b) -> a와 b 사이에 있는 랜덤한 정수 리턴

print(x)
maxNum = Max_Of(x)
print("최대값은 %d 입니다" %maxNum)


