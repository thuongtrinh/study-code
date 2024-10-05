import numpy as np

a = np.array([1, 2, 3])
print(a)  # Output: [1, 2, 3]
print(type(a))  # Output: <class 'numpy.ndarray'>

A = np.array([[1, 2, 3], [3, 4, 5]])
print(A)
A = np.array([[1.1, 2, 3], [3, 4, 5]])  # mảng số thực
print(A)
A = np.array([[1, 2, 3], [3, 4, 5]], dtype=complex)  # mảng số phức
print(A)

# Mọi phần tử đều là 0
A = np.zeros((2, 3))
print(A)
# Mọi phần tử đều là 1
B = np.ones((1, 5))
print(B)

print("\narange reshape")
A = np.arange(4)
print('A =', A)
B = np.arange(12).reshape(2, 6)
print('B =', B)

# Cộng 2 ma trận
print("\nCộng 2 ma trận")
A = np.array([[2, 4], [5, -6]])
B = np.array([[9, -3], [3, 6]])
C = A + B
print(C)

# Nhân 2 ma trận
print("\nNhân 2 ma trận")
A = np.array([[3, 6, 7], [5, -3, 0]])
B = np.array([[1, 1], [2, 1], [3, -3]])
C = a.dot(B)
print(C)

# Chuyển vị ma trận
print("\nChuyển vị ma trận")
A = np.array([[1, 1], [2, 1], [3, -3]])
print(A.transpose())

print("\nXuất các phần tử của ma trận")
A = np.array([12, 14, 16, 18, 20])
print("A[0] =", A[0])
print("A[2] =", A[2])
print("A[-1] =", A[-1])

print("\nXuất các dòng của ma trận")
A = np.array([[1, 4, 5, 12], [-2, 8, 6, 14], [-1, 5, 10, 22]])
print("A[0] =", A[0])  # Dòng đầu tiên

print("\nXuất các cột của ma trận")
print("A[:,0] =", A[:, 0])  # Cột đầu tiên
print("A[:,3] =", A[:, 3])  # Cột thứ 4
print("A[:,-1] =", A[:, -1])  # Cột cuối cùng (Cột thứ 4)

print("\nLát cắt của Ma trận")
A = np.array([1, 3, 5, 7, 9, 7, 5])
# Phần tử thứ tự từ 3 đến 5
print(A[2:5])
# Phần tử thứ tự từ 1 đến 4
print(A[:-5])
# Phần tử thứ 6 trở đi
print(A[5:])
# Lấy cả mảng
print(A[:])
# đổi chiều mảng
print(A[::-1])

print("\nCắt ma trận, ta có ví dụ sau")
A = np.array([[1, 4, 5, 12, 14],  [-5, 8, 9, 0, 17], [-6, 7, 11, 19, 21]])
print(A[:2, :4]) # 2 hàng, 4 cột''' Output:[[ 1 4 5 12] [-5 8 9 0]]'''
print(A[:1,]) # hàng đầu tiên, tất cả cột''' Output:[[ 1 4 5 12 14]]'''
print(A[:,2]) # tất cả các hàng, cột 2''' Output:[ 5 9 11]'''
print(A[:, 2:5]) # tất cả các hàng, cột 3 đến 5'''Output:[[ 5 12 14] [ 9 0 17] [11 19 21]]'''
