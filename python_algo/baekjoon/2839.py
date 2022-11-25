# 설탕 배달

import sys

n = int(sys.stdin.readline())

list_3kg = list(range(0, 5001, 3))
list_5kg = list(range(0, 5001, 5))

minSum_list = []

while True:

    for i in list_3kg:
        for j in list_5kg:
            if n == i + j:
                a = list_5kg.index(j)+ list_3kg.index(i)
                minSum_list.append(a)
                break

    if minSum_list != []:
        break
    else:
        minSum_list.append(-1)
        break


print(min(minSum_list))
    
    
sugar = int(input())

# 좋은 답안 예시

# bag = 0
# while sugar >= 0 :
#     if sugar % 5 == 0 :  # 5의 배수이면
#         bag += (sugar // 5)  # 5로 나눈 몫을 구해야 정수가 됨
#         print(bag)
#         break
#     sugar -= 3  
#     bag += 1  # 5의 배수가 될 때까지 설탕-3, 봉지+1
# else :
#     print(-1)