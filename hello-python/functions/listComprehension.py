letters = ['a', 'b', 'c', 'd']
print(letters)
print("-------------------------------normal-------------------------------")
upper_letters = []
for letter in letters:
    result = letter.upper()
    upper_letters.append(result)

print(upper_letters)

print("-------------------------------Rút gọn-------------------------------")
upper_letters = [x.upper() for x in letters]
print(upper_letters)

print("-------------------------------r1-------------------------------")
ages = [1, 34, 5, 7, 3, 57, 356]
print(ages)
old_ages = [x - 1 for x in ages if x > 10]
print(old_ages)



# letters = ['a', 'b', 'c', 'd', 2]
# print(letters)
# upper_letters = [x.upper() for x in letters]
# print(upper_letters)