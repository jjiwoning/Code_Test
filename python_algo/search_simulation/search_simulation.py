n = int(input())

for i in range(n):
    s = input()
    s = s.lower()
    start = 0
    end = len(s) - 1
    check = "YES"
    while start < end:
        if s[start] == s[end]:
            start += 1
            end -= 1
        else:
            check = "NO"
            break
    
    print("#" + str(i + 1) + " " + check)