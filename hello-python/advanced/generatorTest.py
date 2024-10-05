# Hàm generator đơn giản
def my_gen():
    n = 1
    print('Doan text nay duoc in dau tien')
    # Hàm Generator chứa câu lệnh yield
    yield n

    n += 1
    print('Doan text nay duoc in thu hai')
    yield n

    n += 1
    print('Doan text nay duoc in cuoi cung')
    yield n

# Sử dụng vòng lặp for
for item in my_gen():
    print(item)


print("---------Generator for---------")
def rev_str(my_str):
    length = len(my_str)
    for i in range(length - 1, -1, -1):
        yield my_str[i]

for char in rev_str("hello"):
    print(char)


print("---------Generator vô danh---------")
my_list = [1, 3, 6, 10]

[x**2 for x in my_list] # bình phương mỗi phần tử bằng cách sử dụng list comprehension
a = (x ** 2 for x in my_list) #sử dụng biểu thức generator
print(a)
print(next(a))
print(next(a))
print(next(a))
print(next(a))


print("---------Sum Generator---------")
print(sum(x ** 2 for x in my_list)) #Biểu thức generator sử dụng bên trong các hàm thì có thể bỏ qua các dấu ngoặc tròn.


print("\n---------Generator PowTwo---------")
class PowTwo:
    def __init__(self, max=0):
        self.max = max
        self.n = 0

    def __iter__(self):
        self.n = 0
        return self

    def __next__(self):
        if self.n > self.max:
            raise StopIteration
        result = 2 ** self.n
        self.n += 1
        return result

pt = PowTwo(2)
print(next(pt))
print(next(pt))

print("\n---------Generator PowTwoGen---------")
def PowTwoGen(max=0):
    n = 0
    while n < max:
        yield 2 ** n
        n += 1

ptg = PowTwoGen(2)
print(next(ptg))
print(next(ptg))


print("\n---------Generator list not limit---------")
def all_even():
    n = 0
    while True:
        yield n
        n += 2

nlm = all_even()
print(next(nlm))
print(next(nlm))
print(next(nlm))
print(next(nlm))
print(next(nlm))
print(next(nlm))