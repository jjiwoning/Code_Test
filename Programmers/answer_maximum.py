# 수식 최대화

def solution(expression):
    answer = []
    numbers = "0123456789"
    numLs = []
    opeLs = []
    num = ""
    for i in expression:
        if i in numbers:
            num += i
        else:
            opeLs.append(i)
            numLs.append(int(num))
            num = ""
    
    numLs.append(int(num))
    
    operator = ["*+-", "*-+", "+*-", "+-*", "-+*", "-*+"]

    for i in operator:
        newOpe = opeLs.copy()
        newNum = numLs.copy()
        for j in i:
            while j in newOpe:
                idx = newOpe.index(j)
                newOpe.remove(j)
                if j == "*":
                    findNum = newNum[idx] * newNum[idx + 1]
                elif j == "+":
                    findNum = newNum[idx] + newNum[idx + 1]
                else:
                    findNum = newNum[idx] - newNum[idx + 1]
                newNum.pop(idx)
                newNum.pop(idx)
                newNum.insert(idx, findNum)
        answer.append(abs(newNum[0]))

    return max(answer)

print(solution("100-200*300-500+20"))