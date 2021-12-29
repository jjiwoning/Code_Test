# 정렬된 배열에서 특정 수의 개수 구하기
import time
import sys

def SearchNum(a, index, key):
    start = 0
    last = index - 1
    j = 0
    while True:
        midNum = (last + start) // 2
        if a[midNum] == key:
            i = 1
            num = 1
            while i <= (index-1)//2*(j+1) :
                if a[midNum + i] == key:
                    num += 1
                if a[midNum - i] == key:
                    num += 1
                i+=1
            return num   
        elif a[midNum] < key:
            start = midNum + 1
            j += 1
        elif a[midNum] > key:
            last = midNum - 1
            j += 1
        if(start >= last):
            break
    return -1

index , key = map(int, sys.stdin.readline().split())
list1 = list(map(int, sys.stdin.readline().split()))
start = time.time()
numOfKey = SearchNum(list1, index, key)
print(numOfKey)
print("time:", time.time()-start)