import sys


def isPrimeNumber(n):
    prime = True
    for i in range(2, n):
        if n % i == 0:
            prime = False
            break
    return prime


print("Function to check prime number")
for i in range(1, 100):
    if isPrimeNumber(i):
        print(str(i) + " is prime number")

print("\nPrint element less than 5")
listip = [2, 6, 8, 23, 2, 7, 9, 0, 3, 3, 66, 777]
print([i for i in listip if i < 5])


print(sys.version)
print(sys.version_info)