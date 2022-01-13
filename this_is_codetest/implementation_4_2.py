# 구현, 시각

hour = int(input())

num3 = 0

for i in range(0, hour + 1):
    for min in range(0, 60):
        for sec in range(0, 60):
            nowTime = str(i) + str(min) + str(sec)
            if '3' in nowTime:
                num3 += 1

print(num3)