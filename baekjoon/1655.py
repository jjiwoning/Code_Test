import sys
import heapq

n = int(sys.stdin.readline())

maxHeap = [] # middle 값 + middle 값 보다 작은 값들 넣는 heap
minHeap = [] # middle 값 보다 큰 값들 넣는 heap

for i in range(n):

    num = int(sys.stdin.readline())

    if len(maxHeap) == len (minHeap) :
        # 둘의 길이가 같은 경우는 최대힙에 넣어준다.
        # 파이썬은 기본이 최소힙이라 -num 형태로 최대힙으로 바꿔주는 작업이 필요
        heapq.heappush(maxHeap, (-num, num))
    else:
        heapq.heappush(minHeap, num)
    
    #위의 조건에 따라 값을 넣고 최소힙, 최대힙의 첫 값을 비교해서 최대힙의 값이 더 작게 만들어줘야 된다.
    if minHeap and maxHeap[0][1] > minHeap[0]:
        a = heapq.heappop(minHeap)
        b = heapq.heappop(maxHeap)[1]
        heapq.heappush(maxHeap, (-a, a))
        heapq.heappush(minHeap, b)
    
    print(maxHeap[0][1])
