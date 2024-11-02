class Toyota:
    def dungxe(self):
        print("Toyota dừng xe để nạp điện")

    def nomay(self):
        print("Toyota nổ máy bằng hộp số tự động")


class Porsche:
    def dungxe(self):
        print("Porsche dừng xe để bơm xăng")

    def nomay(self):
        print("Porsche nổ máy bằng hộp số cơ")

# common interface
def kiemtra_dungxe(cars): cars.dungxe()

# instantiate objects
toyota = Toyota()
porsche = Porsche()

# passing the object
kiemtra_dungxe(toyota)
kiemtra_dungxe(porsche)
