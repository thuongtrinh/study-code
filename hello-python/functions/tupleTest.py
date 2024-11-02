# Tuple không thể thay đổi

point = (2, 3)
print(point)

# tuple có thể được tạo mà không cần dấu ()
my_tuple = 10, "txt.com", 3.5
print(my_tuple)

# tuple có nhiều kiểu dữ liệu
my_tuple = (10, "txt.com", 3.5)
print(my_tuple)

# tuple lồng nhau
my_tuple = ("QTM", [2, 4, 6], (3, 5, 7))
print(my_tuple)

# Gán tuple với nhiêu giá trị
yellow = (254, 255, 0)
r, g, b = yellow
print(r, g, b)
print(r)

myseafood = (
    "Tom hùm bỏ lò phomai",
    "Hau nuong mo hanh"
)

for s in myseafood:
    print(s)

# tuple không hỗ trợ việc cập nhật hay xóa
# myseafood[1] = "Tu hai bo lo phomai"
# del myseafood[2]

my_tuple = (1, 3, 5, [7, 9])
my_tuple[3][0] = 8
print(my_tuple)

# Có thể xóa toàn bộ tuple
del my_tuple

QTM = ['t', 'x', 't']
print(QTM.count('t'))
print('x' in QTM)
print('b' in QTM)
print('g' not in QTM)

for ngon_ngu in ('Python', 'C++', 'Web'):
    print("Tôi thích lập trình", ngon_ngu)
