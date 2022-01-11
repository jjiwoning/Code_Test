# 예제 3-1 거스름돈

# 내가 직접 풀어본 코드
# def solution(money):
#     coin500 = money//500
#     money2 = money%500
#     coin100 = money2//100
#     money3 = money2%100
#     coin50 = money3//50
#     money4 = money3%50
#     coin10 = money4//10
#     return(coin500+coin100+coin50+coin10)

# 답안 코드
def solution(money):
    coin_type = [500, 100, 50, 10]
    count = 0
    for coin in coin_type:
        count += money//coin
        money %= coin
    return count

nowMoney = 1260
print(solution(nowMoney))