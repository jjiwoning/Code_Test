a = [1, 1, 1, 9, 1]
enumerateStudy = [(i, p) for i, p in enumerate(a)]
cur = enumerateStudy.pop(0)
print(enumerateStudy)
print(cur)
print(cur[0])
