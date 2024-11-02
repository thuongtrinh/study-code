import fractions
from fractions import Fraction as F

# Tạo phân số từ số thập phân
print(fractions.Fraction(4.5))

# Tạo phân số từ số nguyên
print(fractions.Fraction(9))

# Tạo phân số bằng cách khai báo tử, mẫu số
print(fractions.Fraction(2, 5))

# Khởi tạo phân số từ float
print(fractions.Fraction(0.1))

# Khởi tạo phân số từ string
print(fractions.Fraction('0.1'))

print("\n------Kiểu dữ liệu phân số hỗ trợ đầy đủ các phép toán cơ bản------")
print(F(2, 5) + F(3, 5))
print(F(2, 5) + F(1, 5))
print(1 / F(3, 7))
print(F(-2, 9) > 0)
print(F(-2, 9) < 0)

