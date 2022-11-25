# 부족한 금액 계산하기
def solution(price, money, count):
    totalMoney = 0
    for i in range(1, count+1):
        totalMoney += i*price
    answer = money - totalMoney
    if answer >= 0:
        return 0
    else:
        return -answer