class MyClass2:
    "Đây là class thứ 3 được khởi tạo"
    a = 10
    def func(self):
        print('Xin chào')

ob = MyClass2()

print(MyClass2.func)
print(ob.func)
ob.func()
print(MyClass2.__doc__)