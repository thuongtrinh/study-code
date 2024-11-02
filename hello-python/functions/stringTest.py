import math

print("2. " + math.sin.__doc__)

print("3. Check and add is into name")


def newString(s):
    if s[0:2] == 'is':
        return s
    else:
        return 'is' + s


print(newString('Marry'))

print(5 + int('2'))
print(str(5) + "2")
print(len(str(2 ** 10)))

print("----------------")
word = 'Python'
print(word[0:2])
print(word[:2] + word[2:])

#word[0] = 'J' # -> TypeError: 'str' object does not support item assignment

qtm_string = 'txt.com'
del qtm_string

print("-------Noi chuoi---------")
print(3 * 'un' + 'ium')
print('Py' 'thon')  #Hai hoặc nhiều ký tự dạng chuỗi (tức là ký tự trong dấu nháy) cạnh nhau được nối tự động.

text = ('Put several strings within parentheses '
         'to have them joined together.')
print(text)

print("\n-------loop chuoi---------")
count = 0
for letter in 'txt.com':
    if letter == 't':
        count += 1
print('Có', count, 'chữ t được tìm thấy')

print("\n-------enumerate---------")
qtm_str = 'Python'
qtm_enum = list(enumerate(qtm_str))
print('list(enumerate(qtm_str) = ', qtm_enum)

print("\n-------format---------")
thu_tu_mac_dinh = "{}, {} và {}".format('Quản','Trị','Mạng')
print(thu_tu_mac_dinh)

vi_tri_thu_tu= "{1}, {0} và {2}".format('Quản','Trị','Mạng')
print(vi_tri_thu_tu)

tu_khoa_thu_tu = "{s}, {b} và {j}".format(j='Quản',b='Trị',s='Mạng')
print(tu_khoa_thu_tu)

print("|{:<10}|{:^10}|{:>10}|".format('Quản','Trị','Mạng'))

print("Khi chuyển {0} sang nhị phân sẽ là {0:b}".format(29))
print("Khi chuyển {0} sang bát phân sẽ là {0:o}".format(29))
print("Khi chuyển {0} sang thập lục phân sẽ là {0:0x}".format(29))
print("Số thập phân {0} ở dạng mũ sẽ là {0:e}".format(1566.345))
print("1 phần 3 là: {0:.4f}".format(1/3))

print("\n-----------Định dạng chuỗi kiểu cũ---------------")
x = 15.126789
print('Giá trị của x là %3.2f' %x)
print('Giá trị của x là %3.4f' %x)

print("\n------Phương thức thường được sử dụng trong string--------")
print("TxT.Com".lower())
print("QuanTriMang.Com".upper())
print("Quan Tri Mang Chấm Com".split())
print(' '.join(['Quan', 'Tri', 'Mang', 'Chấm', 'Com']))
print('Quan Tri Mang Chấm Com'.find('Qua'))  # exist = 0 else -1
print('Quan Tri Mang Chấm Com'.replace('Chấm','.'))
