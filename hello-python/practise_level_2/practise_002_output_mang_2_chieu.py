input_str = str(input("Nhập vào 2 số X (row), Y (col): "))

arr = input_str.split(",")
print(arr)
x = int(arr[0])
y = int(arr[1])

XY = [[0 for col in range(y)] for row in range(x)]
print("\nTemplate")
print(XY)

for i in range(x):
    for j in range(y):
        XY[i][j] = i * j

print("\nResult")
print(XY)

print("\n---check---")
x = [999 for t in range(3)]
print(x)
