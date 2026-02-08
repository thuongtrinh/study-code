package org.txt.hello.org.txt.oop.abstracts

// Vd: kết hợp cả Abstract Class và nhiều Interface

// 1. Abstract Class: Định nghĩa bản chất "Là một thiết bị"
abstract class ElectronicDevice(val brand: String) {
    abstract fun powerOn() // Buộc lớp con phải định nghĩa cách bật nguồn

    fun powerOff() { // Hàm dùng chung cho mọi thiết bị
        println("$brand device is powering off...")
    }
}

// 2. Các Interfaces: Định nghĩa các "khả năng" (Capabilities)
interface Camera {
    fun takePhoto()
    fun openApp() { // Default implementation
        println("Opening Camera App...")
    }
}

interface WebBrowser {
    fun browse(url: String)
    fun openApp() { // Trùng tên với Camera để thử thách giải quyết xung đột
        println("Opening Browser App...")
    }
}

// --- Định nghĩa lớp SmartPhone ---
class SmartPhone(brand: String) : ElectronicDevice(brand), Camera, WebBrowser {

    // Thực hiện hàm trừu tượng từ ElectronicDevice
    override fun powerOn() {
        println("$brand SmartPhone is booting up...")
    }

    // Thực hiện hàm từ Camera
    override fun takePhoto() {
        println("Taking a high-quality photo with $brand")
    }

    // Thực hiện hàm từ WebBrowser
    override fun browse(url: String) {
        println("Navigating to $url")
    }

    // Giải quyết xung đột khi có 2 interface đều có hàm openApp()
    override fun openApp() {
        super<Camera>.openApp()      // Gọi hàm của Camera
        super<WebBrowser>.openApp()  // Gọi hàm của WebBrowser
        println("SmartPhone: All apps ready!")
    }
}

fun main() {
    val myPhone = SmartPhone("Samsung")
    myPhone.powerOn()
    myPhone.openApp()
    myPhone.takePhoto()
    myPhone.powerOff()
}
