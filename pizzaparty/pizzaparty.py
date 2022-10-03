n = int(input())
has = []
food = {}
reqs = {}
win = {}
count = 0
for _ in range(n):
    line = input().split()
    if len(line) == 1:
        has.append(line[0])
    else:
        for i in range(1, len(line) - 1, 2):
            if line[i] not in food: food[line[i]] = []
            food[line[i]].append(count)
            reqs[count] = reqs.get(count, 0) + 1
        if len(line) >= 2 and line[2] == 'or':
            reqs[count] = 1 
        win[count] = line[-1]
        count += 1
ans = 0
done = set()
while has:
    f = has.pop()
    if f in done: continue
    done.add(f)
    ans += 1
    if f not in food: continue
    for child in food[f]:
        if reqs[child]:
            reqs[child] -= 1
            if not reqs[child]: has.append(win[child])
print(ans)


