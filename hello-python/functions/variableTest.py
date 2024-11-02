import decimal

hoa, la, canh = "Hồng", 3, 5.5
print(hoa, la, canh)

a = 9
print(type(a))

print(type(5.0))

b = 8 + 2j
print(b + 2)

print(2 + 3.0)

# Kiểm tra xem b có phải là số phức không
print(isinstance(b, complex))

print(0b10111011)
print(0xFA + 0b111)
print(0o17)

print("------number------")
print(int(3.6))
print(int(-1.2))
print(float(7))
print(complex('2+8j'))
print(1.1+2.2)
print((1.1 + 2.2) == 3.3)
print(0.1)
print(decimal.Decimal(0.1))
print(decimal.Decimal('1.1') + decimal.Decimal('2.2'))
print(decimal.Decimal('4.0') * decimal.Decimal('2.50'))

