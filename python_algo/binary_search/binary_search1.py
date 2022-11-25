
def Count(capacity):
    cnt = 1
    sum = 0
    for x in Music:
        if sum + x > capacity:
            cnt += 1
            sum = x
        else:
            sum += x
    return cnt

n, m = map(int, input().split())
Music = list(map(int, input().split()))
lt = max(Music)
rt = sum(Music)
result = 0

while lt <= rt:
    mid = (lt + rt) // 2
    if Count(mid) <= m:
        result = mid
        rt = mid - 1
    else:
        lt = mid + 1

print(result)