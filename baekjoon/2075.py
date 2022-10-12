import sys
import heapq


n = int(sys.stdin.readline())
heap = []

for i in range(n):
    arr = list(map(int, sys.stdin.readline().split()))

    if not heap:
        for j in arr:
            heapq.heappush(heap, j)
    else:
        for j in arr:
            if heap[0] < j:
                heapq.heappush(heap, j)
                heapq.heappop(heap)

print(heap[0])

