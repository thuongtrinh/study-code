print('Sway list elements from original list')
listOriginal = ["anh", "rat", "yeu", "em"]
print(listOriginal)

print("\n-------------Cach 1-------------")
list = listOriginal.copy()
temp = list[0]
list[0] = list[-1]
list[-1] = temp
print(list)

print("\n-------------Cach 2-------------")
list = listOriginal.copy()
temp = list[0],list[-1]
list[-1],list[0] = temp
print(list)

print("\n-------------Cach 3-------------")
list = listOriginal.copy()
list[0],list[-1] = list[-1],list[0]
print(list)

print("\n-------------Cach 4-------------")
list = listOriginal.copy()
a,*b,c = list
list = [c,*b,a]
print(list)


print("\n-------------Cach 5-------------")
list = listOriginal.copy()
a = list.pop(0)
b = list.pop(-1)
list.insert(0, b)
list.append(a)
print(list)




