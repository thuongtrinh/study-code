list = [1, 1, 2, 3, 4, 5, 6]
print("Check monotonic list true/false: ", list)
increased = False
decreased = False

if list[0] < list[1]:
    increased = True
    for i in range(len(list) - 1):
        if list[i] > list[i + 1]:
            increased = False
elif list[0] > list[1]:
    decreased = True
    for i in range(len(list) - 1):
        if list[i] < list[i + 1]:
            decreased = False

if increased:
    print("Monotonic list of increased")
elif decreased:
    print("Monotonic list of decreased")
else:
    print("List input is none Monotonic")
