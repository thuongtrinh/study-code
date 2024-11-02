so_gio_lam = int(input("Nhap so gio lam của tuần: "))
luong_tieu_chuan = float(input("Nhap lương tiêu chuẩn cho mỗi giờ làm: "))

standard_work_hours = 44

salary = 0
if (so_gio_lam > standard_work_hours):
    salary = standard_work_hours * luong_tieu_chuan + (so_gio_lam - standard_work_hours) * luong_tieu_chuan * 1.5
else:
    salary = so_gio_lam * luong_tieu_chuan

print("Your salary: ", salary)

print("-------Cach 2--------")
gio_vuot_chuan = max(0, so_gio_lam - standard_work_hours)  # Số giờ làm vượt chuẩn mỗi tuần
thuc_linh = luong_tieu_chuan * standard_work_hours + gio_vuot_chuan * luong_tieu_chuan * 1.5  # Tính tổng thu nhập
print(f"Số tiền thực lĩnh của nhân viên: {thuc_linh}")
