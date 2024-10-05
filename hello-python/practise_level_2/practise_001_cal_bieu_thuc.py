import math

c = 50
h = 30
value = []

d = str(input("Nhap vao day số D cách nhau bởi dấu phẩy: "))
print(d)

D = d.split(",")
print(tuple(D))

for x in D:
    if x.strip() == '':
        continue
    y = int(round(math.sqrt(2 * c * float(x) / h)))
    value.append(str(y))

kq = ','.join(value)
print("Result: ", kq)

print(int(10.2))
print(round(16.4))
print(round(16.5))
print(round(16.6))
print(math.floor(18.7))
