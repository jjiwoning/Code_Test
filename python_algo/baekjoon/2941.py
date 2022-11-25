# 크로아티아 알파벳

import sys

s = sys.stdin.readline().rstrip()

transfer = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']

for i in transfer:
    s = s.replace(i, '!')

print(len(s))