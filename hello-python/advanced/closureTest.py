def print_msg(msg):
    def printer():
        # Hàm lồng nhau
        print(msg)
    printer()

print_msg("Hello")

print("------ Closure trong Python--------")
def print_msg(msg):
    def printer():
        print(msg)
    return printer

another = print_msg("Hello 2")
another()

print_msg("Hello 3")()


print("------ Khi nào nên sử dụng Closure?--------")
def make_multiplier_of(n):
    def multiplier(x):
        return x * n
    return multiplier

times3 = make_multiplier_of(3)
times5 = make_multiplier_of(5)
print(times3(9))
print(times5(3))
print(times5(times3(2)))
