x = int(input("Nhap vao mot so de in ra dictionary x: "))

j = dict()

def dictionary(n):
    for i in range(1, n + 1):
        print(i)
        j[i] = i * i

dictionary(x)
print(j)
