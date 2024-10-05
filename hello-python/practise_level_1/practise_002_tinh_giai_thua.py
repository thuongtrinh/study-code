x = int(input("Nhap mot so tinh giai thua: "))


def fact(n):
    if n == 0:
        return 1
    else:
        return n * fact(n - 1)


print(fact(x))
