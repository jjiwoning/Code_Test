n = int(input())

a =list(map(int,input().split()))

a = a[::-1]

ans=[]

for x in a:

        ans.insert(x,n)

        n -=1

print(ans)