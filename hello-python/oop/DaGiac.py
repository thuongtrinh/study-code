class DaGiac:
    def __init__(self, socanh):
        self.n = socanh
        self.canh = [0 for i in range(socanh)]

    def nhapcanh(self):
        self.canh = [float(input("Bạn hãy nhập giá trị cạnh " + str(i + 1) + " : ")) for i in range(self.n)]

    def hienthicanh(self):
        for i in range(self.n):
            print("Giá trị cạnh", i + 1, "là", self.canh[i])


dg = DaGiac(5)
dg.nhapcanh()
dg.hienthicanh()


class TamGiac(DaGiac):
    def __init__(self):
        DaGiac.__init__(self, 3)

    def dientich(self):
        a, b, c = self.canh
        print(self.canh)
        print(a, b, c)

        # Tính nửa chu vi
        s = (a + b + c) / 2
        area = (s * (s - a) * (s - b) * (s - c)) ** 0.5
        print('Diện tích của hình tam giác là %0.2f' % area)


tg = TamGiac()
tg.nhapcanh()
tg.hienthicanh()
tg.dientich()

print(issubclass(DaGiac, TamGiac))
print(issubclass(TamGiac, DaGiac))
print(issubclass(bool,int))