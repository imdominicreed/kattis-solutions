number = int(input())
points = 4
columns = 2
for i in range(number): 
  columns = columns*2 -1
points = columns ** 2
print(points)