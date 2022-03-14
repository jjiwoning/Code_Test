# 30
# 30 배수의 조건
# 수 전체 자리를 더했을 때 3의 배수가 나와야되고
# 첫번째 자릿수가 0이 되어야 한다.
# 이 조건으로 알고리즘을 구현해보자
import sys

n = sys.stdin.readline().rstrip()
n = sorted(n, reverse = True)

sum = 0

if '0' not in n:
    print(-1) # 첫번째 자릿수가 0이 되어야 하는데 없으면 안됨
else:
    for i in n:
        sum += int(i)
    if sum % 3 != 0:
        print(-1) # 모든 자릿수를 더했을때 3의 배수가 아니면 안됨
    else:
        print(''.join(n)) # 위의 조건을 만족하면 정렬된 수가 가장 큰 수가 될 수 밖에 없다.




#-----------------------------틀린 풀이--------------------------
# import sys
# from itertools import permutations

# n = int(sys.stdin.readline())
# n = str(n)

# a = list(permutations(n, len(n)))
# a.sort()
# b = 0

# for i in range(len(a)-1 , 0, -1):
#     num = int(''.join(a[i]))
#     if num%30 == 0:
#         print(num)
#         b = 1
#         break

# if b == 0:
#     print(-1)
