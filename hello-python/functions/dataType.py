print("\n----------Immutable Data Types----------")
a = [1, 2, 4]  # a là một list
b = a  # a và b tham chiếu đến cùng một list

print(a)
print(b)

print(id(a))
print(id(b))
print(id(a) == id(b))

a += [8, 16]  # a được sửa đổi và b cũng thế - Vì chúng tham
print(a)
print(b)

print("\n-------------------------------type-------------------------------")
x = 1
print(type(x))
y = 1.5
print(type(y))
z = "hello"
print(type(z))

# None: Kiểu dữ liệu đặc biệt trong Python, để đại diện cho không có gì
x = None
print(x)

print("\n-------------------------------Chuyển đổi giữa các kiểu dữ liệu-------------------------------")
print(float(11))
print(int(18.6))
print(set([2, 4, 6]))
print(tuple({3, 5, 7}))
print(list('txt'))
