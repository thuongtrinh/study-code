def perfect_number(n):
    sum = 0
    for i in range(1, n):
        if n % i == 0:
            sum += i
    if sum == n:
        return True
    else:
        return False


print("Is perfect number ?")
for i in range(1, 1000):
    if (perfect_number(i)):
        print(str(i) + " is perfect number")
