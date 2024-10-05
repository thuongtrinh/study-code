import math

# Gán hàm square cho biến f
f = math.sqrt
# Tính can bac 2 của 4
rs = f(4)
print(rs)


# Ví dụ truyền hàm dưới dạng tham số
def fxy(f, x, y):
    return f(x) + f(y)


# Sử dụng thử hàm vừa tạo
print(fxy(f, 9, 4))

# Khai báo một biến toàn cục
pi = 3.14


# Tạo một hàm tính chu vi hình tròn
def area(r):
    # Sử dụng biến toàn cục trong hàm
    return pi * r * r


# Thử sử dụng hàm vừa tạo để tính toán
print(area(5))

numcalls = 0


# Tạo một hàm tính bình phương
# Sử dụng biến toàn cục để đếm số lần hàm
# vừa tạo được sử dụng
def square(x):
    global numcalls
    numcalls = numcalls + 1
    return x * x


print(square(2))
print(square(5))
print(numcalls)

print(10 / 3)
print(10 // 3)
