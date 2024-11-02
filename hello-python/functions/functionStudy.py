x = 1
def f(x):
    y = x
    x = 2
    return x + y
print(x)
print(f(x))
print(x)

print("---------------------------")
x = 2
def f(a):
    x = a * a
    return x
y = f(3)
print(x, y)

print("-----------Các hàm có thể được gọi với các đối số----------------")
def difference(x, y):
    return x - y
print(difference(5, 2))
print(difference(x = 5, y = 2))
print(difference(5, y = 2))
print(difference(y = 2, x = 5))


print("-----------Và một tham số có thể có giá trị mặc định----------------")
def increment(x, amount = 1):
    return x + amount
print(increment(10))
print(increment(10, 5))
print(increment(10, amount = 2))

print("-----------tạo các hàm sử dụng toán tử lambda----------------")
print(2 ** 3)
f = lambda x: x ** 3
def fxy(f, x, y):
    return f(x) + f(y)
print(fxy(f, 2, 3))

