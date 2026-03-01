package org.txt.hello.org.txt.oop.override

/*
    Để xây dựng một Middleware (lớp trung gian) tự động log lại hành động, chúng ta sẽ sử dụng kỹ thuật Decorator Pattern kết hợp với Delegation.
    Middleware này sẽ bao bọc (wrap) lấy RoleManager hiện tại, ghi lại nhật ký (log) mỗi khi phương thức được gọi, sau đó mới chuyển tiếp yêu cầu tới Delegate thực sự.
    1. Định nghĩa Middleware (Logging Delegate)
    Lớp này sẽ nhận một AccessControl và thực hiện ghi log trước khi thực thi logic gốc.
*/
class AccessLoggingMiddleware(private val base: AccessControl2) : AccessControl2 by base {

    override fun accessLevel(): String {
        println("[LOG]: Kiểm tra quyền truy cập lúc ${java.time.LocalTime.now()}")

        // Gọi logic thực sự từ đối tượng được ủy quyền
        val result = base.accessLevel()

        println("[LOG]: Kết quả trả về: $result")
        return result
    }
}

/*
    2. Tích hợp vào hệ thống SystemUser
    Chúng ta chỉ cần bọc RoleManager bên trong AccessLoggingMiddleware.
*/
class SecureUser(
    val name: String,
    private val roleManager: RoleManager2
) : AccessControl2 by AccessLoggingMiddleware(roleManager) {

    fun changeRole(newRole: UserRole2) {
        println("\n--- Thay đổi quyền cho $name sang ${newRole::class.simpleName} ---")
        roleManager.current = newRole
    }
}

fun main() {
    // 1. Khởi tạo với quyền Guest
    val manager = RoleManager2(UserRole2.Guest2(expired = false))
    val user = SecureUser("Hoàng", manager)

    // Hành động này sẽ kích hoạt Middleware
    val currentLevel = user.accessLevel()
    /*
       Kết quả log:
       [LOG]: Kiểm tra quyền truy cập lúc 14:30:05
       [LOG]: Kết quả trả về: READ_ONLY
    */

    // 2. Nâng cấp lên Admin và thử lại
    user.changeRole(UserRole2.Admin2)
    user.accessLevel()
    /*
       Kết quả log:
       [LOG]: Kiểm tra quyền truy cập lúc 14:30:10
       [LOG]: Kết quả trả về: FULL_ACCESS
    */
}
