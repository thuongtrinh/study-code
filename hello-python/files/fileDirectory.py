import os
import shutil

print(os.getcwd())
print(os.listdir())
# os.remove('new_one')
shutil.rmtree('new_one')
os.mkdir('new_dir')
print(os.listdir())
os.rename('new_dir', 'new_one')
print(os.listdir())

# rmdir() chỉ có thể xóa các thư mục rỗng.
# loại bỏ một thư mục không rỗng, chúng ta có thể sử dụng phương thức rmtree() bên trong module shutil.


