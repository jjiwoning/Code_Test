# 숫자카드

import sys

def binarySearch(array, target):
    start = 0
    end = len(array) - 1
    while start <= end:
        mid = (start + end) // 2

        if array[mid] == target:
            return 1
        elif array[mid] > target:
            end = mid - 1
        else:
            start = mid + 1
    
    return 0

n = int(sys.stdin.readline())
nList = list(map(int, sys.stdin.readline().split()))

m = int(sys.stdin.readline())
mList = list(map(int, sys.stdin.readline().split()))

nList.sort()

for i in mList:
    print(binarySearch(nList, i) , end = " ")
