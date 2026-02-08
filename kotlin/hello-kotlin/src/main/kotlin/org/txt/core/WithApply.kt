package org.txt.hello.org.txt.core

/*
So sánh nhanh with và apply
Rất nhiều bạn mới học thường nhầm lẫn giữa hai hàm này:
apply: Trả về chính đối tượng đó. Thường dùng để khởi tạo (config) đối tượng ngay khi tạo ra.
with: Trả về kết quả của dòng cuối. Thường dùng để thực hiện một nhóm hành động trên một đối tượng đã tồn tại sẵn
*/

class Person3 {
    var namePerson: String = ""
    var agePerson: Int = 0

    // Hàm hỗ trợ in thông tin để kiểm tra kết quả
    fun displayInfo() {
        println("Tên: $namePerson, Tuổi: $agePerson")
    }
}

fun main() {
    //1. So sánh nhanh: also vs apply
    // Dùng apply để cấu hình (setting)
    val student = Person2("An", 20).apply {
        age = 21 // Truy cập trực tiếp vì dùng 'this'
    }
    println("student = $student")

    // Dùng also để log thông tin
    val studentLog = Person2("An", 20).also {
        println("Tuổi của ${it.name} là ${it.age}") // Phải dùng 'it'
    }

    val person = Person3().apply {
        namePerson = "Duy" // Truy cập trực tiếp thuộc tính nhờ 'this' ngầm định
        agePerson = 25
    }
    person.displayInfo()

    //Dùng run khi: Vừa muốn cấu hình đối tượng, vừa muốn tính toán trả về một kết quả.
    val description = person.run {
        "Người này là $name, $age tuổi" // Trả về String này
    }
    println(description)

    // 2. with (Thực hiện nhiều thao tác trên một đối tượng)
    // Thay vì gọi person.name, person.age, person.sayHello()
    with(person) {
        println("Tên: $name") // Truy cập trực tiếp thuộc tính
        println("Tuổi: $age")
        displayInfo()         // Gọi trực tiếp phương thức
    }

    // Dùng with để lấy giá trị trả về
    val personInfo = with(person) {
        "Thông tin: $name ($age tuổi)" // Dòng cuối cùng được trả về
    }
    println(personInfo)

    // Let
    val name: String? = "kotlin"
    val length = name?.let {
        println("Tên không null, đang tính độ dài...")
        it.length // Trả về giá trị này
    }
    println(length)
}

/*
Hàm	    Tham chiếu	Giá trị trả về	    Mục đích chính
let	    it	        Kết quả lambda	    Kiểm tra null, biến đổi object.
run	    this	    Kết quả lambda	    Tính toán trên object và trả về kết quả.
with	this	    Kết quả lambda	    Gọi nhiều hàm trên cùng một object.
apply	this	    Chính object đó	    Khởi tạo, cấu hình (Config) object.
also	it	        Chính object đó	    Ghi log, thực hiện hành động phụ.
*/
