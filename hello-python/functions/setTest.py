# Khai báo một set
x = {1, 2, 3, 2, 1}
# In set
print(x)
print('4' in x)

# Tạo set rỗng
qtm = set()
print(type(qtm))

# set là tập hợp các phần tử không có thứ tự nên ko có chỉ mục
# print(x[1]) #TypeError

print("--------------------------------------------")
my_set = {1.0, "Xin chào", (1, 2, 3)}
print(my_set)
my_set.add(2)  # Thêm phần tử
print(my_set)
my_set.update([2, 3, 4])  # Thêm nhiều phần tử vào set
print(my_set)
my_set.update([4, 5], {1, 6, 8})  # Thêm list và set
print(my_set)
my_set.discard(4)
print(my_set)
# my_set.remove(64) #remove sẽ báo lỗi nếu phần tử cần xóa không tồn tại
# print(my_set)
print(my_set.pop())  # xóa phần tử bằng pop()
print(my_set)
my_set.clear()
print(my_set)

print("\n----------Set thường được sử dụng để chứa các toán tử tập hợp-----------")
A = {1, 2, 3, 4, 5}
B = {4, 5, 6, 7, 8}
print(A | B)
print(A.union(B))
print(B.union(A))
print(A - B)
print(A.difference(B))
print(B - A)
print(B.difference(A))
print(A ^ B)
print(A.symmetric_difference(B))
