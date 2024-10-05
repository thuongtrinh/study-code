for num in range(2, -5, -1):
    print(num, end=", ")
print()

print("---for else---")
B = [0, 2, 4, 5]
for b in B:
    print(b)
else:
    print("Đã hết số.")

dem = 0
while dem < 3:
    print("Đang ở trong vòng lặp while")
    dem = dem + 1
else:
    print("Đang ở trong else")

flag = 0
while (flag): print("Flag đã cho là True!")
print("Hẹn gặp lại!")

x = 0
while (x < 100):
    x += 2
print(x)
