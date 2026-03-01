package org.txt.hello.org.txt.collection

/*
    Đây là bản Cheat Sheet tóm tắt toàn bộ "vũ trụ" Collection trong Kotlin. Bạn có thể lưu lại để tra cứu nhanh khi code.
    1. Khởi tạo (Initialization)
    Loại	Read-only (Chỉ đọc)	Mutable (Có thể sửa)
    List	listOf(1, 2)	mutableListOf(1, 2)
    Set	setOf(1, 2)	mutableSetOf(1, 2)
    Map	mapOf("A" to 1)	mutableMapOf("A" to 1)

    2. Các hàm xử lý phổ biến (Transformation & Filter)
    filter { ... }: Giữ lại các phần tử thỏa mãn điều kiện.
    map { ... }: Biến đổi từng phần tử sang một giá trị/kiểu mới.
    flatMap { ... }: Biến đổi và "trải phẳng" danh sách lồng nhau.
    groupBy { ... }: Nhóm các phần tử vào một Map dựa trên tiêu chí.
    associateBy { ... }: Tạo Map với Key là một thuộc tính của phần tử.

    3. Xử lý Null Safety
    filterNotNull(): Loại bỏ hoàn toàn null.
    mapNotNull { ... }: Vừa biến đổi vừa loại bỏ kết quả null.
    firstOrNull { ... }: Lấy phần tử đầu tiên hoặc trả về null (tránh crash).
    list.orEmpty(): Nếu list là null, trả về một list rỗng thay vì gây lỗi.

    4. Hiệu năng & Nâng cao
    asSequence(): Chuyển sang xử lý "lười" (Lazy), dùng khi chuỗi thao tác dài hoặc dữ liệu lớn.
    distinct(): Loại bỏ các phần tử trùng lặp (giống Set).
    take(n) / drop(n): Lấy hoặc bỏ qua n phần tử đầu tiên.
    zip(other): Ghép đôi hai danh sách thành các cặp Pair.

    Lời khuyên: Luôn ưu tiên dùng Read-only List (listOf) mặc định.
    Chỉ chuyển sang mutableListOf khi bạn thực sự cần thêm/xóa phần tử để giữ cho code an toàn và ít lỗi logic nhất.
 */