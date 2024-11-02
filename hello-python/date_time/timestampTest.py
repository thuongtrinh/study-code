from datetime import datetime
import time

timestamp = 1562907183
dt_object = datetime.fromtimestamp(timestamp)

print("dt_object =", dt_object)
print("type(dt_object) =", type(dt_object))

# ngay gio hien tai
now = datetime.now()

timestamp = datetime.timestamp(now)
print("timestamp =", timestamp)
print("Ngay gio hien tai:", now)

print("\n--------------ctime-------------------")
seconds = time.time()
print("So giay tinh tu epoch:", seconds)

seconds = 1562983783.9618232
local_time = time.ctime(seconds)
print("Local time:", local_time)

print("\n--------------localtime struct_time-------------------")
result = time.localtime(1562983783)
print("Ket qua:", result)
print("Nam:", result.tm_year)
print("Gio:", result.tm_hour)

print("\n--------------gmtime-------------------")
result = time.gmtime(1562983783)
print("Ket qua:", result)
print("Nam:", result.tm_year)
print("Gio:", result.tm_hour)

print("\n--------------mktime-------------------")
t = (2019, 7, 13, 9, 9, 43, 5, 194, 0)
local_time = time.mktime(t)
print("Gio dia phuong:", local_time)

print("\n--------------mktime-------------------")
seconds = 1562983783

# trả về struct_time
t = time.localtime(seconds)
print("t1: ", t)

# trả về giây từ struct_time
s = time.mktime(t)
print("s:", s)

print("\n--------------asctime-------------------")
t = (2019, 7, 13, 9, 9, 43, 5, 194, 0)

result = time.asctime(t)
print("Ket qua:", result)

print("\n--------------sleep-------------------")
print ("Start :", time.ctime())
time.sleep(2)
print ("End :", time.ctime())
