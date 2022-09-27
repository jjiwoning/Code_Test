from collections import deque


n = int(input())

ls = list(map(int, input().split()))

command = ""

last = 0

lt = 0
rt = n - 1
subList = []

while lt <= rt :
    if ls[lt] > last:
        subList.append((ls[lt], "L"))
    
    if ls[rt] > last:
        subList.append((ls[rt], "R"))
    
    subList.sort()

    if len(subList) == 0:
        break
    else:
        command += subList[0][1]
        last = subList[0][0]
        if subList[0][1] == "L":
            lt += 1
        else:
            rt -= 1
    
    subList.clear()

print(len(command))
print(command)


