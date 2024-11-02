import datetime

print("Nhap ngay thang nam sinh de tinh tuoi.")
birth_day = int(input("Ngày sinh: "))
birth_month = int(input("Tháng sinh: "))
birth_year = int(input("Năm sinh: "))

current_year = datetime.date.today().year
current_month = datetime.date.today().month
current_day = datetime.date.today().day

print("Current date: " + str(current_year) + "-" + str(current_month) + "-" + str(current_day))
age_year = current_year - birth_year
age_month = abs(current_month - birth_month)
age_day = abs(current_day - birth_day)

print("### Tuổi của bạn chính xác là:### \n", age_year, " tuổi ", age_month, " tháng ", age_day, " ngày")
