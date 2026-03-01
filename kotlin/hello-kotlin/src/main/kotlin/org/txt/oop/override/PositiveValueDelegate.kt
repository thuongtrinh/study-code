package org.txt.hello.org.txt.oop.override

import kotlin.reflect.KProperty
/*
    Định nghĩa Delegate kiểm tra điều kiện
    Sử dụng hàm setValue để chặn các giá trị không hợp lệ trước khi chúng được gán vào biến thực tế.
*/
class PositiveValueDelegate(private var value: Int) {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): Int = value

    operator fun setValue(thisRef: Any?, property: KProperty<*>, newValue: Int) {
        if (newValue > 0) {
            value = newValue
            println("Cập nhật ${property.name} thành $newValue")
        } else {
            println("Lỗi: Giá trị $newValue không hợp lệ cho ${property.name} (phải > 0)")
        }
    }
}
