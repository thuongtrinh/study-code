package com.txt.java.structure.version.java25;

/**
 * Lớp cha đại diện cho một thực thể có ID.
 */
class BaseEntity {
    protected int id;

    public BaseEntity(int id) {
        this.id = id;
    }
}

/**
 * Lớp minh họa tính năng Flexible Constructor Bodies của Java 25.
 * Cho phép xử lý logic và validate trước khi gọi super().
 *
 * @author AI Assistant
 * @since Java 25
 */
class ChildEntity extends BaseEntity {
    private String name;

    public ChildEntity(int inputId, String name) {
        // --- TÍNH NĂNG JAVA 25: KHÔNG CẦN super() Ở DÒNG ĐẦU TIÊN ---
        // Java cũ: Bắt buộc super(inputId) phải là dòng đầu tiên, không thể kiểm tra dữ liệu trước.
        // Java 25: Thoải mái kiểm tra tính hợp lệ trước khi khởi tạo lớp cha.
        if (inputId < 0) {
            throw new IllegalArgumentException("ID hệ thống không được phép âm!");
        }

        int securedId = inputId + 9999; // Xử lý/mã hóa dữ liệu trước

        super(securedId); // Gọi constructor lớp cha sau khi dữ liệu đã sạch
        this.name = name;
    }

    public void display() {
        System.out.println("Kết quả sau xử lý -> ID: " + id + " | Tên: " + name);
    }
}

/**
 * Class chính trùng tên với File để tránh lỗi biên dịch khi copy vào Project.
 */
public class Java25FeaturesDemo {

    public static void main(String[] args) {
        System.out.println("--- Chạy thử nghiệm tính năng Java 25 thành công ---");

        try {
            // Thử nghiệm trường hợp hợp lệ
            ChildEntity sample = new ChildEntity(5, "Cú pháp Java 25");
            sample.display();

            // Thử nghiệm tính năng bảo vệ (Validate trước super)
            System.out.println("\nThử nhập ID âm để kiểm tra bộ lọc:");
            ChildEntity errorSample = new ChildEntity(-1, "Lỗi");

        } catch (IllegalArgumentException e) {
            System.out.println("Hệ thống đã chặn thành công: " + e.getMessage());
        }
    }
}

