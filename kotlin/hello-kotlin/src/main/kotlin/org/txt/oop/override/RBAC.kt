package org.txt.hello.org.txt.oop.override

/*
    Để xây dựng hệ thống Phân quyền (RBAC) bằng Dynamic Delegation, ta coi mỗi "Quyền" (Role) là một đối tượng thực thi. Khi người dùng đăng nhập hoặc đổi tài khoản, ta chỉ cần tráo đổi đối tượng Delegate tương ứng.
    1. Định nghĩa Interface Quyền hạn
    Chúng ta dùng Interface để quy định các hành động trong hệ thống.
*/
interface AccessControl {
    fun viewDashboard()
    fun deleteUser()
}

// Quyền của Admin
class AdminRole : AccessControl {
    override fun viewDashboard() = println("Admin: Hiển thị toàn bộ thống kê.")
    override fun deleteUser() = println("Admin: Đã xóa người dùng thành công.")
}

// Quyền của Guest (Khách)
class GuestRole : AccessControl {
    override fun viewDashboard() = println("Guest: Chỉ hiển thị thông tin công khai.")
    override fun deleteUser() = println("Lỗi: Bạn không có quyền xóa người dùng!")
}

/*
2. Wrapper để Tráo đổi Quyền (Dynamic Delegate)
Lớp này đóng vai trò là "công tắc" để thay đổi thực thể quyền hạn đang hoạt động.
*/
class RoleSwitcher(var currentRole: AccessControl) : AccessControl {
    override fun viewDashboard() = currentRole.viewDashboard()
    override fun deleteUser() = currentRole.deleteUser()
}

/*
    3. Lớp User sử dụng Delegation
    Lớp User sẽ ủy quyền mọi hành vi bảo mật cho RoleSwitcher.
*/
class User1(private val roleSwitcher: RoleSwitcher) : AccessControl by roleSwitcher {
    fun login(newRole: AccessControl) {
        println("\n--- Đang chuyển đổi sang quyền mới ---")
        roleSwitcher.currentRole = newRole
    }
}

fun main() {
    // Ban đầu là khách
    val switcher = RoleSwitcher(GuestRole())
    val currentUser = User1(switcher)

    currentUser.viewDashboard()
    currentUser.deleteUser()

    // Sau khi đăng nhập Admin
    currentUser.login(AdminRole())
    currentUser.viewDashboard()
    currentUser.deleteUser()
}

/*
    Lợi ích của phương pháp này:
    Tính bảo mật cao: Logic kiểm tra quyền được tách biệt hoàn toàn khỏi logic nghiệp vụ của lớp User.
    Mở rộng dễ dàng: Muốn thêm quyền Moderator? Chỉ cần tạo lớp mới kế thừa AccessControl mà không cần sửa code hiện có (Tuân thủ SOLID - Open/Closed Principle).
    Code sạch: Loại bỏ các câu lệnh if (isAdmin) { ... } else { ... } rườm rà trong toàn bộ ứng dụng.
*/
