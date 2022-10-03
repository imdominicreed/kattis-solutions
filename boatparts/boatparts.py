def solve():
    p,n = map(int, input().split())
    d = set()
    for i in range(n):
        d.add(input())
        if len(d) == p:
            print(i+1)
            return
    print('paradox avoided')
solve()
