import array

#Bạn có thể thao tác với list giống như mảng nhưng không thể ép kiểu phần tử được lưu trữ trong list
arr = [1, 3.5, "Hello", [1, 3.5, "Hello"]]
print(arr)

# Nếu bạn tạo mảng sử dụng mô-đun array, tất cả các phần tử của mảng phải có cùng kiểu số.
# a = array.array('d', [1, 3.5, "Hello"]) #Chạy code này sẽ báo lỗi
# print(a)

# chúng ta cần nhập mô-đun array để tạo các mảng
a = array.array('d', [1.1, 3.5, 4.5, 2])  # Chữ 'd' là mã kiểu
print(a)
print(a[0], a[-2])


print("\n---------Bạn có thể truy cập vào một dải phần tử trong mảng, sử dụng toán tử cắt lát---------")
numbers_list = [5, 85, 65, 15, 95, 52, 36, 25]
numbers_array = array.array('i', numbers_list)
print(numbers_array[2:5].tolist()) # Phần tử thứ 3 đến 5
print(numbers_array[:-5]) # Phần tử đầu tiên đến 4
print(numbers_array[5:]) # Phần tử thứ 6 đến hết
print(numbers_array[:]) # Phần tử đầu tiên đến cuối cùng

print("\n---------Thay đổi, thêm phần tử trong mảng Python----------")
numbers = array.array('i', [1, 1, 2, 5, 7, 9])

# thay đổi phần tử đầu tiên
numbers[0] = 0
print(numbers)

# thay phần tử thứ 3 đến thứ 5
numbers[2:5] = array.array('i', [4, 6, 8])
print(numbers)

print("\n---------thêm một mục vào list sử dụng append, extend----------")
numbers = array.array('i', [3, 5, 7])

numbers.append(4)
print(numbers)

# extend() nối vào cuối mảng
numbers.extend([5, 6, 7])
print(numbers)

print("\n---------2 mảng cũng có thể nối lại thành một nhờ toán tử +  ---------")
mang_le = array.array('i', [3, 5, 7])
mang_chan = array.array('i', [2, 6, 8])

numbers = array.array('i') # tạo mảng trống
numbers = mang_le + mang_chan
print(numbers)

print("\n---------Xóa phần tử của mảng trong Python---------")
number = array.array('i', [1, 3, 3, 5, 7])

del number[2]  # xóa phần tử thứ 3
print(number)

# del number # xóa toàn bộ mảng
# print(number) # Error: array 'number' is not defined

print("\n---------Chia tách phần tử trong mảng---------")
# Tạo danh sách
l = [1, 2, 3, 4, 5, 6, 7, 8, 9, 10]

a = array.array('i', l)
print("Initial Array: ")
for i in (a):
    print(i, end=" ")

# In các nhân tố của một mảng, Dùng toán tử Slice
Sliced_array = a[3:8]
print("\nSlicing elements in a range 3-8: ")
print(Sliced_array)

# In các nhân tố từ điểm xác định trước tới cuối
Sliced_array = a[5:]
print("\nElements sliced from 5th element till the end: ")
print(Sliced_array)

# In các nhân tố từ điểm bắt đầu tới cuối
Sliced_array = a[:]
print("\nPrinting all elements using slice operation: ")
print(Sliced_array)



