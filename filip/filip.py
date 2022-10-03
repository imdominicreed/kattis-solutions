numbers = input()
list = numbers.split()
for i in range(2):
    list[i] = list[i][::-1]
print((list[0] , list[1])[list[1] > list[0]])
