A = [[1, 4, 5, 12], [-5, 8, 9, 0], [-6, 7, 11, 19]]

print("A =", A)
print("A[1] =", A[1])  # Hàng thứ 2 của ma trân
print("A[1][2] =", A[1][2])  # Phần tử thứ 3 của hàng thứ 2
print("A[0][-1] =", A[0][-1])  # Phần tử cuối cùng của hàng 1
column = [];
for row in A: column.append(row[2])
print("Cột thứ 3 =", column)
