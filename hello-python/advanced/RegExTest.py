import re

pattern = '^a...s$'
test_string = 'abyss'
result = re.match(pattern, test_string)

if result:
    print("Tim kiem thanh cong.")
else:
    print("Tim kiem khong thanh cong.")

print("\n--------findall-----------")
string = 'hello 12 hi 89. Howdy 34'
pattern = '\d+'

result = re.findall(pattern, string)
print(result)


print("\n--------split-----------")
string = 'The rain in Vietnam.'
pattern = '\s'
result = re.split(pattern, string)
print(result)

string = 'The rain in Vietnam.'
pattern = '\s'
result = re.split(pattern, string, 1)
print(result)


print("\n--------sub-----------")
# chuỗi nhiều dòng
string = 'abc 12\
de 23 \n f45 6'

# so khớp các ký tự khoảng trắng
pattern = '\s+'

# chuỗi rỗng
replace = ''

new_string = re.sub(pattern, replace, string)
print(new_string)


print("\n--------subn-----------")
string = 'abc 12\
de 23 \n f45 6 \n quantrimang website'

pattern = '\s+'
new_string = re.subn(pattern, replace, string)
print(new_string)


print("\n--------search-----------")
string = "Quantrimang.com la website ban co the hoc Python"

# Kiem tra xem 'Quantrimang' co nam o dau chuoi khong
match = re.search('\AQuantrimang', string)
if match:
    print("Tim thay 'Quantrimang' nam o dau chuoi")
else:
    print("'Quantrimang' khong nam o dau chuoi")


print("\n--------group-----------")
string = '39801 356, 2102 1111'
pattern = '(\d{3}) (\d{2})'

match2 = re.search(pattern, string)
if match2:
    print(match2.group())
else:
    print("Không khớp")

print(match2.group(1))
print(match2.group(2))
print(match2.group(1, 2))
print(match2.groups())

print(match2.start())
print(match2.end())
print(match2.span())

print(match2.re)  #trả về một biểu thức chính quy.

print("\n-----------Sử dụng tiền tố r trước RegEx-------------")
string = '\n and \r are escape sequences.'

result = re.findall(r'[\n\r]', string)
print(result)
