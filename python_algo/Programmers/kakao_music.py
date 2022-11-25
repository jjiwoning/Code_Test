def change(music):
    if 'A#' in music:
        music = music.replace('A#', 'a')
    if 'F#' in music:
        music = music.replace('F#', 'f')
    if 'C#' in music:
        music = music.replace('C#', 'c')
    if 'G#' in music:
        music = music.replace('G#', 'g')
    if 'D#' in music:
        music = music.replace('D#', 'd')
    return music


def solution(m, musicinfos):
    answer = []
    index = 1
    m = change(m)
    for i in musicinfos:
        s, e, name, code = i.split(",")
        sh, sm = s.split(":")
        eh, em = e.split(":")
        start = 60 * int(sh) + int(sm)
        end = 60 * int(eh) + int(em)
        time = end - start
        code = change(code)
        while len(code) < time:
            code = code * 2
        code = code[:time]
        if m in code:
            answer.append((time, index, name))
            index += 1

    answer.sort(key=lambda x: (-x[0], x[1]))

    if answer:
        return answer[0][2]
    else:
        return "(None)"

print(solution("ABCDEFG", ["12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"]))