l = list(map(int, input().split()))
towers = l[0:6]
towers.sort()
a,b = l[6:]
def solve(t):
    for i in range(len(towers)):
        for j in range(i+1,len(towers)):
            for k in range(j+1, len(towers)):
                if towers[i]+towers[j]+towers[k] == t:
                    a,b,c=towers[k],towers[j],towers[i]
                    towers.pop(k)
                    towers.pop(j)
                    towers.pop(i)
                    return [a,b,c]
l = solve(a)
l += solve(b)
print(*l)
