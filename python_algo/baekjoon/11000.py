import heapq
import sys

n = int(sys.stdin.readline())

ls = []

for i in range(n):
    ls.append(tuple(map(int, sys.stdin.readline().split())))

ls.sort()

heap = []

heapq.heappush(heap, ls[0][1])

for i in range(1, len(ls)):
    if heap[0] <= ls[i][0]:
        heapq.heappop(heap)
        heapq.heappush(heap, ls[i][1])
    else:
        heapq.heappush(heap, ls[i][1])

print(len(heap))