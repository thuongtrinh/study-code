package org.txt.hello.org.txt.oop.override

/*
    Trong Kotlin, việc kết hợp nhiều Interface Delegation cho phép bạn lắp ghép các tính năng như những khối Lego.
    Đây là cách giải quyết triệt để vấn đề "đa kế thừa" mà không làm code bị rối.
    Dưới đây là ví dụ tạo ra một thực thể SmartDevice (Thiết bị thông minh) bằng cách kết hợp tính năng từ MusicPlayer và LightControl.
    1. Định nghĩa các Interface và Lớp thực thi
    Mỗi lớp thực thi sẽ đảm nhận một trách nhiệm riêng biệt (Single Responsibility).
*/
interface MusicPlayer {
    fun playMusic(track: String)
}

interface LightControl {
    fun setBrightness(level: Int)
}

// Lớp thực thi âm nhạc
class SonyAudioSystem : MusicPlayer {
    override fun playMusic(track: String) = println("Đang phát '$track' với âm thanh Hi-Res")
}

// Lớp thực thi ánh sáng
class PhilipsHueSystem : LightControl {
    override fun setBrightness(level: Int) = println("Đèn đã chỉnh độ sáng lên $level%")
}

/*
    2. Lắp ghép bằng Interface Delegation
    Lớp SmartSpeaker sẽ được "ủy quyền" hoàn toàn cho hai hệ thống trên.
*/
class SmartSpeaker(
    audio: MusicPlayer,
    lights: LightControl
) : MusicPlayer by audio, LightControl by lights {

    // Bạn có thể override thêm logic riêng của SmartSpeaker
    fun voiceCommand(cmd: String) {
        println("Lệnh giọng nói: $cmd")
    }
}

/*
    3. Cách sử dụng linh hoạt
    Bạn có thể dễ dàng thay đổi linh kiện bên trong mà không cần sửa code của SmartSpeaker.
*/
fun main() {
    val myAudio = SonyAudioSystem()
    val myLights = PhilipsHueSystem()

    // Kết hợp các module lại
    val alexa = SmartSpeaker(myAudio, myLights)

    alexa.voiceCommand("Chill out time")
    alexa.playMusic("Lofi Beats")    // Gọi đến SonyAudioSystem
    alexa.setBrightness(30)         // Gọi đến PhilipsHueSystem
}

/*
    Ưu điểm vượt trội:
    Sạch sẽ (Clean Code): Lớp SmartSpeaker không chứa một dòng code logic nào về âm thanh hay ánh sáng, nó chỉ làm nhiệm vụ kết nối.
    Dễ kiểm thử (Testable): Bạn có thể truyền các bản giả (Mock) của MusicPlayer vào để test SmartSpeaker cực kỳ đơn giản.
    Hoán đổi linh hoạt: Nếu sau này bạn đổi sang loa Samsung, chỉ cần tạo SamsungAudioSystem và truyền vào lúc khởi tạo, mọi thứ vẫn chạy hoàn hảo.
*/