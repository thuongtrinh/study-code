x = input("Input number separated by commas: ")
list1 = x.split(",")
tuple1 = tuple(list1)
print(list1)
print(tuple1)

file = input("1. Input file name: ")
y = file.split(".")
print("File extension is: ", y[-1])
