# 잃어버린 괄호

import sys

sik = sys.stdin.readline().strip()

calList = []

for i in sik:
    if "+" == i:
        calList.append("+")
    elif "-" == i:
        calList.append("-")

for i in sik:
    if i == "+":
        sik = sik.replace("+", " ")
    if i == "-":
        sik = sik.replace("-", " ")

numList = list(map(int, sik.split()))

# 구현 로직
# - 다음에 있는 +는 무조건 -로 간주해도 된다. (괄호를 치기 떄문에)
# 대신 -가 앞에 없는 +는 절대로 -로 만들면 안된다.
for i in range(len(calList)):
    if calList[i] == "-":
        if i != (len(calList) - 1):
            calList[i+1] = "-"

# 구현 로직
# 숫자, 연산, 숫자, 연산, 숫자 패턴
# -> 맨 처음 숫자를 min으로 설정하고 (연산 숫자)를 붙여서 for 문을 돌리자.

minSum = numList[0]
numList.pop(0)

for i in range(len(calList)):
    if calList[i] == "+":
        minSum += numList[i]
    else:
        minSum -= numList[i]

print(minSum)
