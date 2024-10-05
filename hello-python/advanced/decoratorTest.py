def first(msg):
    print(msg)

first("Hello")
second = first
second("Hello")

print("----------Decorator 1-------------")
def inc(x):
    return x + 1

def dec(x):
    return x - 1

def operate(func, x):
    result = func(x)
    return result

print(operate(inc,3))
print(operate(dec,3))

print("----------Decorator 2-------------")
def is_called():
    def is_returned():
        print("Hello")
    return is_returned

new = is_called()
new()

print("----------Decorator 3-------------")
def make_pretty(func):
    def inner():
        print("I got decorated")
        func()
    return inner

def ordinary_first():
    print("I am ordinary first")

ordinary_first()

pretty = make_pretty(ordinary_first)
pretty()

print("-------------Cach ký hiệu @-------------")
@make_pretty
def ordinary():
    print("I am ordinary second")

ordinary()

print("\n----------Tham số hàm decorator 1-------------")
def divide_first(a, b):
    return a/b

print(divide_first(2,5))

print("\n----------Tham số hàm decorator 2-------------")
def smart_divide(func):
    def inner(a,b):
        print("I am going to divide",a,"and",b)
        if b == 0:
            print("Whoops! cannot divide")
            return

        return func(a,b)
    return inner

@smart_divide
def divide(a,b):
    return a/b

print(divide(2,5))
print("----------------")
divide(2,0)

print("\n----------Tham số hàm decorator 3-------------")
def works_for_all(func):
    def inner(*args, **kwargs):
        print("I can decorate any function")
        return func(*args, **kwargs)
    return inner


print("\n----------Chuỗi Decorator-------------")
def star(func):
    def inner(*args, **kwargs):
        print("*" * 30)
        func(*args, **kwargs)
        print("*" * 30)
    return inner

def percent(func):
    def inner(*args, **kwargs):
        print("%" * 30)
        func(*args, **kwargs)
        print("%" * 30)
    return inner

@star
@percent
def printer(msg):
    print(msg)

printer("Hello")






