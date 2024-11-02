# Khai bao mot list
my_list = [4, 7, 0, 3]

# lay mot iterator bang cach su dung iter()
my_iter = iter(my_list)

print(next(my_iter))
print(next(my_iter))
## next(obj) chinh la obj.__next__()

print(my_iter.__next__())
print(my_iter.__next__())

## Xay ra loi StopIteration vi het gia tri tra ve
# next(my_iter)

print("-------For----------")
for element in my_list:
    print(element)

print("-------while----------")
iter_obj = iter(my_list)
while True:
    try:
        element = next(iter_obj)
        print(element)
    except StopIteration:
        print("StopIteration except")
        break

print("-------PowTwo----------")
class PowTwo:
    def __init__(self, max = 0):
        self.max = max

    def __iter__(self):
        self.n = 0
        return self

    def __next__(self):
        if self.n <= self.max:
            result = 2 ** self.n
            self.n += 1
            return result
        else:
            raise StopIteration  # lệnh StopIteration tránh lặp lại mãi mãi

a = PowTwo(4)
i = iter(a)
print(next(i))
print(next(i))
print(next(i))
print(next(i))
print(next(i))

print("-------for PowTwo----------")
for i in PowTwo(5):
    print(i)

print("-------InfIter----------")

class InfIter:
    def __iter__(self):
        self.num = 1
        return self
    def __next__(self):
        num = self.num
        self.num += 2
        return num

a = iter(InfIter())
print(next(a))
print(next(a))
print(next(a))

print("-------mytuple----------")
mytuple = ("apple", "banana", "cherry")
myit = iter(mytuple)
print(next(myit))
print(next(myit))
print(next(myit))