class Person:
    def __init__(self, name, age):
        self.name = name
        self.age = age

    def myfunc(self):
        print("Xin chào, tên tôi là " + self.name)

p1 = Person("Quantrimang.com", 16)
p1.myfunc()
