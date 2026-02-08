package org.txt.hello.org.txt.core

/*
Kotlin: Sử dụng ký tự $ trực tiếp trong chuỗi.
Nối chuỗi String Templates: ($variable)
So sánh chuỗi giá trị: ==
Chuỗi nhiều dòng Phải dùng Strings: ( """...""" )
*/

val name = "Tuấn"
val age = 20

fun RawStrings() {
    // Kotlin: Giữ nguyên định dạng mong muốn.
    val json = """
    {
    "id": 1
    }
    """.trimIndent()
    println(json)
}

fun getEmployeeQuery(name: String, minSalary: Int, departmentId: Int): String {
    return """
SELECT id, name, salary
FROM employees
WHERE name LIKE '%$name%'
AND salary >= $minSalary
AND dept_id = $departmentId
ORDER BY salary DESC
""".trimIndent()
}

fun createUpdateUserJson(userId: Int, newStatus: String, isAdmin: Boolean): String {
    return """
{
"user_id": $userId,
"status": "$newStatus",
"is_admin": $isAdmin,
"updated_at": "${java.time.LocalDateTime.now()}"
}
""".trimIndent()
}

fun main() {
    println("Tên: $name, Tuổi: $age") // Rất trực quan
    RawStrings()

    // Trong Java, hàm split() sử dụng Regex (biểu thức chính quy) mặc định, đôi khi gây nhầm lẫn (ví dụ: split(".") ).
    // Kotlin tách bạch rõ ràng giữa chuỗi và Regex.
    val date = "2024.12.31"
    val parts = date.split(".") // Kotlin hiểu đây là ký tự '.' bình thường
    println("Splitting: $parts")

    println("\ngetEmployeeQuery:\n" + getEmployeeQuery("Tuấn", 15000000, 5))
    println("\ncreateUpdateUserJson:\n" + createUpdateUserJson(111, "active", true))
}