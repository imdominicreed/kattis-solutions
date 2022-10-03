n,k = map(int, input().split())
cache = [[[-1 for _ in range(k+1)] for _ in range(n)] for _ in range(3)]
arr = []
sum = 0
for i in range(n):
    a,b = map(int, input().split())
    sum += a + b
    arr.append([a,b])
def inv(invalid):
    if invalid == 2: return 2
    return (invalid+1)%2
def dfs(invalid, i,k):
    global n
    if k == 0: return 0
    if i >= n: return 10000000
    if cache[invalid][i][k] != -1: return cache[invalid][i][k] 
    m = dfs(2, i+1,k)
    for j in range(2):
        if j != inv(invalid):
            m = min(m, dfs(j, i+1, k-1) + arr[i][j])
    cache[invalid][i][k] = m
    return m 
print(sum-dfs(2,0,k))
