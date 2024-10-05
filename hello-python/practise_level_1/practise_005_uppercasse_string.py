class InputOutString(object):
    def __init__(self):
        self.s = ""

    def inputString(self):
        self.s = input("Nhập chuỗi: ")

    def printString(self):
        print(self.s.upper())


strObj = InputOutString()
strObj.inputString()

print(strObj.s)
strObj.printString()
