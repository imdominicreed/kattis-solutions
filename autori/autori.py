fullName = input()
names = fullName.split('-')
answer = ""
for name in names:
    answer += name[0]
print(answer)
