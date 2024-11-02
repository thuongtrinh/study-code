import functools

print("----------First Class Functions----------")
def f(function, *arguments):
    return function(*arguments)

print(f(max, 1, 2, 4, 8, 16))


print("----------Recursive Function----------")
def factorial_r(n):
    if n == 0:
        return 1
    return n * factorial_r(n - 1)

print(factorial_r(5))


print("\n----------Anonymous Functions----------")
f = lambda x, y: x + y

def g(x, y):
    return x + y

print(f(3, 4))
print(g(3, 4))

print("\n----------Mapping----------")
print(list(map(lambda item: 2 * item, [-2, -1, 0, 1, 2])))

print("\n----------Reducing----------")
print(list(filter(lambda item: item >= 0, [-2, -1, 0, 1, 2])))

print("\n----------Reducing----------")
print(functools.reduce(lambda x, y: x + y, [1, 2, 4, 8, 16]))
