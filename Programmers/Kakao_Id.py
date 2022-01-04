# ID 추천해주기
# 문자열 인덱싱 a[0:5] -> 0이상 5 미만 인덱스

def solution(new_id):
    alpha = {'A':'a', 'B':'b', 'C':'c','D':'d','E':'e','F':'f','G':'g','H':'h','I':'i','J':'j','K':'k','L':'l','M':'m','N':'n','O':'o','P':'p','Q':'q','R':'r','S':'s','T':'t','U':'u','V':'v','W':'w','X':'x','Y':'y','Z':'z','!':'','@':'','#':'','*':'','=':'','+':'','^':'','"':'',"'":'','$':'','%':'','&':'','(':'',')':'','<':'','>':'','?':'','/':'',',':'',':':'','[':'',']':'','}':'','{':'','~':'' }
    answer = ''
    for i in str(new_id):
        if i in alpha.keys(): #딕셔너리에 있는 키 값이면
            i = alpha[i] #키 값에 해당하는 밸류로 바꿔줌
        answer += i # 다 더해줌
        answer = answer.replace('...','.') #"..."을 '.' 으로 변환 해줌
        answer = answer.replace('..','.') #위와 같은 원리
    if answer == '.':
        answer = 'a'
    if answer[0] == '.':
        answer = answer[1:]
    if answer[-1] == '.':
        answer = answer[:-1]
    if answer == '':
        answer = 'a'
    if len(answer) >= 16:
        answer = answer[:15]
        if answer[-1] == '.':
            answer = answer[:-1]
    if len(answer) <= 2:
        while len(answer) <=2:
            answer += answer[-1]
    
    return answer

# 테스트 케이스 시범
userID = "z-+.^."
print(solution(userID))