class Person2:
    def __init__(mysillyobject, name, age):
        mysillyobject.name = name
        mysillyobject.age = age

    def myfunc(abc):
        print("Xin chào r, tên tôi là " + abc.name)


p1 = Person2("Quantrimang.com", 16)
p1.myfunc()
