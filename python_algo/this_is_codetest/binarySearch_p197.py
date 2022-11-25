# 부품 찾기

import sys

n = int(sys.stdin.readline())
nList = list(map(int, sys.stdin.readline().split()))
m = int(sys.stdin.readline())
mList = list(map(int, sys.stdin.readline().split()))

nList.sort()

def binarySearch(array, target, start, end):
    while start <= end:
        mid = (start + end) // 2
        
        if array[mid] == target:
            return 'yes'
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    return 'no'

for i in mList:
    print(binarySearch(nList, i, 0, len(nList)-1) , end = ' ')