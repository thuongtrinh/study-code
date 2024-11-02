mauso = input("Bạn hãy nhập giá trị mẫu số: ")
try:
    ketqua = 15 / int(mauso)
    print("Kết quả là:", ketqua)
finally:
    print("Bạn đã nhập số không thể thực hiện phép tính.")

try:
    x = input('Nhập một số trong khoảng 1-10: ')
    if int(x) < 1 or int(x) > 10:
        raise Exception
    else:
        print('Bạn vừa nhập một số hợp lệ :D')
except:
    print('Số bạn vừa nhập nằm ngoài khoảng cho phép mất rồi!')


mauso = input("Bạn hãy nhập giá trị mẫu số: ")
try:
    ketqua = 15 / int(mauso)
    print("Kết quả là:", ketqua)
finally:
    print("Bạn đã nhập số không thể thực hiện phép tính.")
