n = int(input())

ls = list(map(int, input().split()))

cnt = int(input())

for i in range(cnt):
    ls.sort()
    ls[0] += 1
    ls[-1] -= 1

ls.sort()

print(ls[-1] - ls[0])




    


