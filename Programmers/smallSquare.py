# 최소 직사각형

def solution(sizes):
    for i in range(len(sizes)):
        sizes[i].sort
    hMax = -1
    wMax = -1
    for i in sizes:
        if i[0] >= hMax:
            hMax = i[0]
        if i[1] >= wMax:
            wMax = i[1]
    
    return hMax*wMax