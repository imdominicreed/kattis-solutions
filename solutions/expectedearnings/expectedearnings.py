inp = input().split()
n = int(inp[0])
k = int(inp[1])
p = float(inp[2])
if n*p >= k:
    print('spela inte!')
else:
    print('spela')