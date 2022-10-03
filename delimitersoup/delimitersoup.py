n = int(input())
l = str(input())
s = []
d = {'{':'}', '[':']', '(':')'}
for i in range(n):
  if l[i] == ' ':
    continue
  if l[i] in d:
    s.append(d[l[i]])
  elif  len(s) == 0 or s.pop() != l[i]:
    print(l[i], i)
    exit()
print('ok so far') 