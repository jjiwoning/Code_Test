# 표 편집

# n : 처음 표의 행 갯수
# k : 처음 선택한 행의 위치
# cmd : 수행한 명령어

def solution(n, k, cmd):
    answer = ['O'] * n
    remember = []
    for i in cmd:
        if i[0] == 'U':
            cnt = int(i[2:])
            while cnt:
                if answer[k-1] != 'X':
                    cnt -= 1
                    k -= 1
                else:
                    k -= 1
        elif i[0] == 'D':
            cnt = int(i[2:])
            while cnt:
                if answer[k+1] != 'X':
                    cnt -= 1
                    k += 1
                else:
                    k += 1
        elif i == 'C':
                answer[k] = 'X'
                remember.append(k)
                if k == n-1 or ('O' not in answer[k+1:]):
                    cnt = 1
                    while cnt:
                        if answer[k-1] != 'X':
                            cnt -= 1
                            k -= 1
                        else:
                            k -= 1
                else:
                    cnt = 1
                    while cnt:
                        if answer[k+1] != 'X':
                            cnt -= 1
                            k += 1
                        else:
                            k += 1

        else:
            answer[remember.pop()] = 'O'

    return ''.join(answer)

n = 8
k = 2
cmd = ["D 2","C","U 3","C","D 4","C","U 2","Z","Z"]

print(solution(n, k, cmd))
