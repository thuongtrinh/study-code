import datetime
import pytz

# ngày giờ hiện tại
now = datetime.datetime.now()
t = now.strftime("%H:%M:%S")
print("time:", t)

s1 = now.strftime("%m/%d/%Y, %H:%M:%S")
print("s1:", s1)

s2 = now.strftime("%d/%m/%Y, %H:%M:%S")
print("s2:", s2)

print("---------------------")
date_string = "7 March, 2019"
print("date_string =", date_string)

date_object = datetime.datetime.strptime(date_string, "%d %B, %Y")
print("date_object =", date_object)


print("\n------Hiển thị múi giờ trong Python  sử dụng module pytZ------")
local = datetime.datetime.now()
print("Local:", local.strftime("%m/%d/%Y, %H:%M:%S"))

tz_NY = pytz.timezone('America/New_York')
datetime_NY = datetime.datetime.now(tz_NY)
print("NY:", datetime_NY.strftime("%m/%d/%Y, %H:%M:%S"))

tz_London = pytz.timezone('Europe/London')
datetime_London = datetime.datetime.now(tz_London)
print("London:", datetime_London.strftime("%m/%d/%Y, %H:%M:%S"))

print("\n-------Hiển thị ngày hiện tại ở các định dạng khác nhau--------")
today = datetime.date.today()

# dd/mm/YY
d1 = today.strftime("%d/%m/%Y")
print("d1 =", d1)

# Tháng viết đầy đủ
d2 = today.strftime("%B %d, %Y")
print("d2 =", d2)

# mm/dd/y
d3 = today.strftime("%m/%d/%y")
print("d3 =", d3)

# Tháng viết tắt
d4 = today.strftime("%b-%d-%Y")
print("d4 =", d4)

print("\n---------------------------")
now = datetime.datetime.now()
print("now =", now)

# dd/mm/YY H:M:S
dt_string = now.strftime("%d/%m/%Y %H:%M:%S")
print("Ngay va gio hien tai =", dt_string)

current_time = now.strftime("%H:%M:%S")
print("Gio hien tai =", current_time)
print("type(now) =", type(now))

print("\n------Hiển thị thời gian hiện tại sử dụng module time------")
t = datetime.time()
current_time = datetime.time.strftime("%H:%M:%S", t)
print(current_time)
