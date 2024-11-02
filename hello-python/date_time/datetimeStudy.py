import datetime
import time

#Có gì bên trong datetime?
print(dir(datetime))

date_in = (28, 9, 2023)
date_out = "%i/%i/%i" % date_in
print(date_out)

sk1 = datetime.date(2024, 12, 2)
sk2 = datetime.date(2023, 12, 3)
delta = sk1 - sk2
print(delta)

print("------------In ra thời gian ở dạng chuỗi------------")
print(time.asctime())
print(datetime.datetime.now())
print(datetime.date(2022, 4, 12))

timestamp = datetime.date.fromtimestamp(1551916800)
print("Date =", timestamp)

print("\n----------date--------------")
today = datetime.date.today()
print("Ngay hien tai la:", today)
print("Nam hien tai:", today.year)
print("Thang hien tai:", today.month)
print("Ngay hien tai:", today.day)

print("\n----------time--------------")

# time(hour = 0, minute = 0, second = 0)
a = datetime.time()
print("a =", a)

b = datetime.time(11, 34, 56)
print("b =", b)

c = datetime.time(hour = 15, second = 32, minute = 53)
print("c =", c)

d = datetime.time(11, 34, 56, 234566)
print("d =", d)

a = datetime.time(11, 34, 56)
print("hour =", a.hour)
print("minute =", a.minute)
print("second =", a.second)
print("microsecond =", a.microsecond)

print("\n---------datetime.datetime------------")
a = datetime.datetime(2019, 3, 7)
print(a)
b = datetime.datetime(2019, 3, 7, 23, 55, 59, 342380)
print(b)

print("------------------------")
a = datetime.datetime(2019, 3, 7, 23, 55, 59, 342380)
print("year =", a.year)
print("month =", a.month)
print("hour =", a.hour)
print("minute =", a.minute)
print("timestamp =", a.timestamp())

print("\n----------ko timedelta--------------")
# khoảng thời gian chênh lệch giữa 2 ngày tháng
t1 = datetime.date(year = 2018, month = 7, day = 12)
t2 = datetime.date(year = 2017, month = 12, day = 23)
t3 = t1 - t2
print("t3 =", t3)

t4 = datetime.datetime(year = 2018, month = 7, day = 12, hour = 7, minute = 9, second = 33)
t5 = datetime.datetime(year = 2019, month = 6, day = 10, hour = 5, minute = 55, second = 13)
t6 = t4 - t5
print("t6 =", t6)

print("\n---------timedelta 1---------------")
t1 = datetime.timedelta(weeks = 2, days = 5, hours = 1, seconds = 33)
t2 = datetime.timedelta(days = 4, hours = 11, minutes = 4, seconds = 54)
t3 = t1 - t2

print("t3 =", t3)

print("\n---------timedelta 2---------------")
t1 = datetime.timedelta(seconds = 33)
t2 = datetime.timedelta(seconds = 54)
t3 = t1 - t2
print("t3 =", t3)
print("t3 =", abs(t3))

t = datetime.timedelta(days = 5, hours = 1, seconds = 33, microseconds = 233423)
print("tong so giay =", t.total_seconds())
