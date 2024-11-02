# Lists (Biến đổi)

list1 = []  # list rỗng
x = ["hello", "world"]
y = [1, 2, "hello", "world", ["another", "list"]]  # list với kiểu dữ liệu hỗn hợp
print(x)
x[1] = 4
print(x[1])
print(y)

# Khai báo một list
mylist = [2, 9, 5, 4, 8, 6]
print("\n----------mylist----------")
print("Length = " + str(len(mylist)))
print("Min = " + str(min(mylist)))
print("Max = " + str(max(mylist)))
print("Sum = " + str(sum(mylist)))
print(mylist)

print("\n----------list lồng nhau----------")
a = ['a', 'b', 'c']
n = [1, 2, 3]
ln_list = [a, n]
print(ln_list)
print(ln_list[0][1])
print(ln_list[1][2])
print(a + [36, 49, 64, 81, 100])

print("\n----------list update----------")
letters = ['a', 'b', 'c', 'd', 'e', 'f', 'g']
letters.remove('a')
print(letters)

letters[2:5] = ['C', 'D', 'E']
print(letters)

letters[2:5] = []
print(letters)

letters[:] = []
print(letters)

print("\n-----------List comprehension--------------")
cub3 = [3 ** x for x in range(9)]
print(cub3)

cub3 = [3 ** x for x in range(9) if x > 4]
print(cub3)

so_le = [x for x in range(18) if x % 2 == 1]
print(so_le)

noi_list = [x + y for x in ['Ngôn ngữ ', 'Lập trình '] for y in ['Python', 'C++']]
print(noi_list)

QTM = ['q', 'u', 'a', 'n']
print('q' in QTM)
print('.' in QTM)
print('z' in QTM)

for ngon_ngu in ['Python', 'Java', 'C']:
    print("Tôi thích lập trình", ngon_ngu)

print("\n--------Các hàm Python tích hợp với list----------")
lst = [1, 2, 3, 4, 5]
print(all(lst))
print(any(lst))
print(list(enumerate(lst)))

prime_numbers = [2, 3, 5, 7]
prime_numbers.reverse()
print(prime_numbers.reverse())  # Note
print('Reversed List:', prime_numbers)
