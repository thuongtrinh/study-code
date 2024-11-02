list = [1, 2, 3, 4, 5, 6]
print("Check monotonic list true/false: ", list)
increased = all(list[i] <= list[i + 1] for i in range(len(list) - 1))
decreased = all(list[i] >= list[1 + 1] for i in range(len(list) - 1))

if increased:
    print("Monotonic list of increasing")
elif decreased:
    print("Monotonic list of decreasing")
else:
    print("List input is none Monotonic")
