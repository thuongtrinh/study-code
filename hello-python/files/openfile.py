f = open("test.txt")
print(f)

try:
    f = open("test.txt", encoding='utf-8')
finally:
    f.close()

with open("test.txt", 'w', encoding='utf-8') as f:
    f.write("Quantrimang\n")
    f.write("Kiến thức - Kinh nghiệm - Hỏi đáp\n\n")
    f.write("Quantrimang.com\n")

f = open("test.txt", 'r', encoding='utf-8')
a = f.read(11)
print('Nội dung 11 kí tự đầu là:\n', a)
b = f.read(35)
print('Nội dung 35 kí tự tiếp theo là:\n', b)
c = f.read()
print('Nội dung phần còn lại là:\n', c)

f = open("test.txt", 'r', encoding='utf-8')
a = f.read(12)
print('Nội dung là: \n', (a))
b = f.tell()
print('Vị trí hiện tại: ', (b))
f.seek(0)
c = f.read()
print('Nội dung mới là: \n', (c))

f = open("test.txt", 'r', encoding='utf-8')
a = f.readline()
print('Nội dung dòng đầu: ', (a))
b = f.readline()
print('Nội dung dòng 2: ', (b))
c = f.readline()
print('Nội dung dòng 3: ', (c))
d = f.readline()
print('Nội dung dòng 4: ', (d))


f = open("test.txt",'r',encoding = 'utf-8')
a = f.readline()
print ('Nội dung dòng đầu: ', (a))
b = f.readlines()
print ('Nội dung các dòng còn lại: \n', (b))
c = f.readlines()
print ('Nội dung các dòng còn lại: \n', (c))
