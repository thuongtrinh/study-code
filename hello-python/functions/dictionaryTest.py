# Khai báo một dictionary
person = {"name": "smith", "email": "hello@smith.com.vn"}
print(person['name'])

dict1 = {}  # dictionary rỗng
print(type(dict1))

dict2 = {1: 'txt.com', 2: 'Công nghệ', 'txt': 'Tech'}
dict3 = {'tên': 'QTM', 1: [1, 3, 5]}
dict4 = dict({1: 'apple', 2: 'ball'})
dict5 = dict([(1, 'QTM'), (2, 'CN')])

print(dict2)
print("dict2[1] = ", dict2[1])
print("dict2[txt] = ", dict2['txt'])

print(dict3)
print(dict4)
print(dict5)

users = {'firstname': 'John', 'lastname': 'Smith', 'age': 27}
print(users.keys())

print("------------------------------------")
binh_phuong = {1: 1, 2: 4, 3: 9, 4: 16, 5: 25}
print(binh_phuong.pop(4))  # xóa phần tử số 4
print(binh_phuong)
del binh_phuong[2]  # xóa phần tử cụ thể
print(binh_phuong)
print(binh_phuong.popitem())  # xóa phần tử bất kỳ
binh_phuong.clear()
print(binh_phuong)
del binh_phuong

lap_phuong = {x: x * x * x for x in range(6)}
print(lap_phuong)
lap_phuong_chan = {x: x * x * x for x in range(10) if x % 2 == 0}
print(lap_phuong_chan)
lap_phuong = {0: 0, 1: 1, 2: 8, 3: 27, 4: 64, 5: 125}
print(2 in lap_phuong)  # kiểm tra key của phần tử
for i in lap_phuong:  # lặp qua key
    print(lap_phuong[i])
