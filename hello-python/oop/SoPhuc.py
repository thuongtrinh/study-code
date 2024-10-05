class SoPhuc:
    def __init__(self, r=0, i=0):
        self.phanthuc = r
        self.phanao = i

    def getData(self):
        print("{}+{}j".format(self.phanthuc, self.phanao))


# Tạo đối tượng số phức mới
c1 = SoPhuc(2, 3)

# Gọi hàm getData()
# Output: 2+3j
c1.getData()

# Tạo đối tượng số phức mới
# tạo thêm một thuộc tính mới (new)
c2 = SoPhuc(5)
c2.new = 10

# Output: (5, 0, 10)
print((c2.phanthuc, c2.phanao, c2.new))

# Đối tượng c1 không có thuộc tính 'new'
# AttributeError: 'SoPhuc' object has no attribute 'new'
# c1.new

c1 = SoPhuc(2, 3)
# del c1.phanao
c1.getData()
del SoPhuc.getData