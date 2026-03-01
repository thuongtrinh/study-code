package org.txt.hello.org.txt.oop.override

/*
    Việc kết hợp Sealed Class giúp bạn giới hạn chính xác những loại Role nào được phép tồn tại trong hệ thống,
    giúp câu lệnh when trở nên an toàn hơn vì trình biên dịch sẽ kiểm tra đủ các trường hợp (exhaustive check).
    1. Định nghĩa Sealed Class cho các Role
    Thay vì chỉ là các class rời rạc, ta đặt chúng vào một Sealed Class.
*/
interface AccessControl2 {
    fun accessLevel(): String
}

sealed class UserRole2 : AccessControl2 {
    object Admin2 : UserRole2() {
        override fun accessLevel() = "FULL_ACCESS"
    }

    object Moderator2 : UserRole2() {
        override fun accessLevel() = "LIMITED_ACCESS (Edit only)"
    }

    data class Guest2(val expired: Boolean) : UserRole2() {
        override fun accessLevel() = if (expired) "NO_ACCESS" else "READ_ONLY"
    }
}

/*
    2. Bộ chuyển đổi Role an toàn
    Chúng ta sử dụng một lớp trung gian để thực hiện Delegation dựa trên trạng thái của Sealed Class.
*/
class RoleManager2(var current: UserRole2) : AccessControl2 by current

class SystemUser2(val name: String, private val roleManager: RoleManager2) : AccessControl2 by roleManager {

    fun updateRole(newRole: UserRole2) {
        roleManager.current = newRole
    }

    // Một hàm ví dụ sử dụng lợi thế của Sealed Class
    fun printRoleInfo() {
        val info = when (val role = roleManager.current) {
            is UserRole2.Admin2 -> "Quyền tối cao cho $name"
            is UserRole2.Moderator2 -> "Người kiểm duyệt: $name"
            is UserRole2.Guest2 -> "Khách truy cập (Hết hạn: ${role.expired})"
        }
        println(info)
    }
}

fun main() {
    val manager = RoleManager2(UserRole2.Guest2(expired = false))
    val user = SystemUser2("An", manager)

    user.printRoleInfo()        // Kết quả: Khách truy cập (Hết hạn: false)
    println("Level: ${user.accessLevel()}") // Kết quả: READ_ONLY

    // Nâng cấp quyền lên Admin
    user.updateRole(UserRole2.Admin2)
    user.printRoleInfo()        // Kết quả: Quyền tối cao cho An
    println("Level: ${user.accessLevel()}") // Kết quả: FULL_ACCESS
}
