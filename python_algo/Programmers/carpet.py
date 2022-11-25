def solution(brown, yellow):
    answer = []
    total = brown + yellow
    height = 1
    width = total / height
    while True:
        if int(width) != width:
            height += 1
            width = total / height
        findYellow = (height - 2) * (width - 2)
        if findYellow == yellow:
            answer.append(width)
            answer.append(height)
            break
        height += 1
        width = total / height
    return answer