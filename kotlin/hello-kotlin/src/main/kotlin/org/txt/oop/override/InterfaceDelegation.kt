package org.txt.hello.org.txt.oop.override

/*
    Interface Delegation (Ủy quyền Interface) là một tính năng cực kỳ mạnh mẽ của Kotlin,
    giúp bạn thực hiện mô hình Composition over Inheritance (Ưu tiên kết hợp hơn kế thừa).
    Thay vì tự viết code override cho mọi phương thức, bạn "thuê" một đối tượng khác làm việc đó giúp mình.

    1. Cú pháp sử dụng từ khóa by
    Để ủy quyền toàn bộ một interface, bạn sử dụng cú pháp: class Con : Interface by DoiTuongThucThi.
*/

interface SoundBehavior {
    fun makeSound()
}

// Lớp thực thi cụ thể (Delegate)
class BarkBehavior : SoundBehavior {
    override fun makeSound() = println("Woof Woof!")
}

class MeowBehavior : SoundBehavior {
    override fun makeSound() = println("Meow Meow!")
}

// Lớp chính: Không cần tự viết code makeSound, chỉ cần "ủy quyền"
class Dog1(sound: SoundBehavior) : SoundBehavior by sound

fun main() {
    val barkingDog = Dog1(BarkBehavior())
    barkingDog.makeSound() // Kết quả: Woof Woof!

    val catLikeDog = Dog1(MeowBehavior())
    catLikeDog.makeSound() // Kết quả: Meow Meow!
}

/*
2. Ghi đè (Override) lại khi cần thiết
Mặc dù đã ủy quyền toàn bộ, bạn vẫn có thể ghi đè thủ công một vài phương thức cụ thể nếu muốn thay đổi logic mặc định của delegate.
*/
class RobotDog(sound: SoundBehavior) : SoundBehavior by sound {
    // Chỉ ghi đè cái mình muốn, còn lại dùng của 'sound'
    override fun makeSound() {
        print("Bíp bíp... ")
        // Nếu muốn gọi code của delegate, bạn không thể dùng super trực tiếp ở đây
    }
}

/*
    3. Tại sao nên dùng Interface Delegation?
    Tránh "Fat Classes": Thay vì nhồi nhét mọi logic vào một class, bạn chia nhỏ chúng ra các class behavior khác nhau.
    Thay đổi hành vi linh hoạt: Bạn có thể thay đổi cách class hoạt động ngay lúc khởi tạo (Run-time) bằng cách truyền các đối tượng thực thi khác nhau vào.
    Đa kế thừa (Giả): Một lớp có thể ủy quyền cho nhiều Interface cùng lúc, giúp tái sử dụng code từ nhiều nguồn mà không gặp lỗi "Diamond Problem" như trong Java.
    Ex: class HybridVehicle(engine: Engine, GPS: Navigation) : Engine by engine, Navigation by GPS
*/