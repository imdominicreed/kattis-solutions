n = int(input())
g = {}
for i in range(n):
	s = input().split()
	if s[-1] not in g: g[s[-1]] = set()
	g[s[-1]].add(s[0]+ ' ' + s[1])
keys = sorted(g.keys())
for k in keys:
	print(k, len(g[k]))

