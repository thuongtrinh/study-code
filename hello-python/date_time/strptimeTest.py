from datetime import datetime

date_string = "11 July, 2019"
print("date_string =", date_string)

date_object = datetime.strptime(date_string, "%d %B, %Y")
print("date_object =", date_object)

print("\n------------------")
dt_string = "11/07/2018 09:15:32"

dt_object1 = datetime.strptime(dt_string, "%d/%m/%Y %H:%M:%S")
print("dt_object1 =", dt_object1)

dt_object2 = datetime.strptime(dt_string, "%m/%d/%Y %H:%M:%S")
print("dt_object2 =", dt_object2)

print("\n-------ValueError -----------")
date_string = "11/07/2018"
date_object = datetime.strptime(date_string, "%d %m %Y")  # correct: "%d/%m/%Y"

print("date_object =", date_object)
