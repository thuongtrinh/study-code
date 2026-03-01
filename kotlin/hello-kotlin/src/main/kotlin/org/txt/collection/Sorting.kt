package org.txt.hello.org.txt.collection

fun main() {
    // 1. Học viên < 20 tuổi còn buổi tập
    val hasYoungMemberWithSessions = members.any { it.age < 20 && it.sessionsLeft > 0 }
    println("Kết quả: $hasYoungMemberWithSessions") // Output: false (Vì An 17 tuổi nhưng sessionsLeft = 0)

    // 2. Sắp xếp trong Collection (Sorting)
    // A. Sắp xếp cơ bản (Dành cho List số hoặc chữ)
    val numbers = listOf(5, 2, 10, 1)
    println(numbers.sorted())           // [1, 2, 5, 10]
    println(numbers.sortedDescending()) // [10, 5, 2, 1]

    // B. Sắp xếp theo thuộc tính (Dành cho Object)
    // Sắp xếp học viên theo tuổi tăng dần
    val sortedByAge = members.sortedBy { it.age }
    println(sortedByAge)

    // Sắp xếp theo số buổi tập còn lại từ cao xuống thấp
    val mostSessions = members.sortedByDescending { it.sessionsLeft }
    println("Học viên nhiều buổi nhất: ${mostSessions.first().name}") // Chi

    // C. Sắp xếp đa tiêu chí (Nâng cao)
    val complexSort = members.sortedWith(
        compareBy<Member> { it.age }.thenBy { it.name }
    )
    println(complexSort)

    // 3. Lưu ý quan trọng về Hiệu năng
    // Các hàm sorted() luôn tạo ra một List mới. Nếu bạn đang dùng MutableList và muốn sắp xếp trực tiếp trên danh sách đó để tiết kiệm bộ nhớ, hãy dùng:
    // sort() thay vì sorted()
    // sortBy { ... } thay vì sortedBy { ... }
    val mutableList = mutableListOf(3, 1, 2)
    mutableList.sort() // Sắp xếp ngay trên chính nó, không tạo list mới
    println(mutableList)
}

/*
    Cheat Sheet Sắp xếp:
    Số/Chữ đơn giản: sorted()
    Theo thuộc tính: sortedBy { it.property }
    Nhiều điều kiện: sortedWith(compareBy(...))
    Tối ưu Mutable: sort()

    So sánh hiệu năng (Quick Tips)
    Mục tiêu	        Cách làm chậm O(n.log(n))       Cách làm nhanh O(n)
    Tìm người già nhất	sortedBy { it.age }.last()	    maxByOrNull { it.age }
    Tìm giá rẻ nhất	    sortedBy { it.price }.first()	minByOrNull { it.price }
    Tìm số lớn nhất	    sorted().last()	                maxOrNull()
 */