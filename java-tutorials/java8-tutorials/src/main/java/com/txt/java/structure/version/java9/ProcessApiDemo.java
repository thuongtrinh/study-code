package com.txt.java.structure.version.java9;

/**
 * ProcessApiDemo - Hệ Sinh Thái Quản Lý Tiến Trình Hệ Điều Hành (Process API Improvements) Trong Java 9
 * <p>
 * Minh họa cách sử dụng ProcessHandle để tương tác, giám sát và lấy thông tin chi tiết của các tiến trình (Processes)
 * đang chạy trên hệ điều hành (OS) một cách trực tiếp từ mã nguồn Java mà không cần gọi lệnh native của OS.
 * <p>
 * Các thành phần và tính năng cốt lõi của Process API trong Class:
 * - ProcessHandle.current(): Lấy đối tượng đại diện cho tiến trình Java hiện tại đang thực thi đoạn mã này.
 * - current.pid(): Trả về ID định danh duy nhất (Process ID) của tiến trình trên hệ thống.
 * - current.children(): Trả về một Stream chứa danh sách toàn bộ các tiến trình con do tiến trình hiện tại sinh ra.
 * - ProcessHandle.Info: Lớp chứa thông tin chi tiết của tiến trình bao gồm: đường dẫn lệnh, User vận hành, thời gian bắt đầu và thời lượng CPU.
 * <p>
 * Java version: Java 9+ (2017) -> [Tính năng mới cải tiến từ Java 8 lên Java 9]
 * <p>
 * Bóc tách cấu trúc dữ liệu của ProcessHandle.Info:
 * <p>
 * | Phương thức thông tin | Kiểu dữ liệu trả về (Bọc trong Optional) | Ý nghĩa thực tế trên Hệ điều hành (OS)      | Mục đích sử dụng chính                      |
 * |-----------------------|-------------------------------------------|---------------------------------------------|---------------------------------------------|
 * | 1. .command()         | Optional<String>                          | Đường dẫn tuyệt đối đến file thực thi (.exe) | Xác định ứng dụng nào đang chạy             |
 * | 2. .user()            | Optional<String>                          | Tên tài khoản hệ thống đang chạy ứng dụng   | Kiểm tra phân quyền bảo mật (Root/Admin/User)|
 * | 3. .startInstant()    | Optional<Instant>                         | Thời điểm chính xác tiến trình được khởi tạo | Giám sát thời gian sống (Uptime) của App    |
 * | 4. .totalCpuDuration()| Optional<Duration>                        | Tổng thời gian CPU đã tiêu tốn cho tác vụ   | Đo lường hiệu năng và cảnh báo ngốn tài nguyên|
 * <p>
 * Ví dụ so sánh kỹ thuật cũ (Java 8) vs Hiện đại (Java 9 Process API):
 * <p>
 * | Tiêu chí kỹ thuật   | Tiếp cận kiểu cũ (Java 8 về trước với Runtime.getRuntime())                                  | Tiếp cận hiện đại (Java 9+ với ProcessHandle)                              |
 * |---------------------|-----------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------|
 * | 1. Lấy mã PID       | Không có hàm hỗ trợ trực tiếp. Phải viết mã mẹo (Hack code) thông qua tên vùng nhớ JMX:        | `ProcessHandle.current().pid();`                                            |
 * | của ứng dụng        | `ManagementFactory.getRuntimeMXBean().getName().split("@")[0];` -> Rất dễ lỗi trên OS khác nhau.| Trả về ngay lập tức dạng số long, chạy ổn định, đồng bộ trên mọi nền tảng OS.|
 * | 2. Quản lý cây      | Hoàn toàn bất lực. Muốn biết tiến trình con hoặc tắt một tiến trình bất kỳ, bắt buộc phải     | Gọi `.children()` để lấy danh sách con hoặc dùng `.destroy()` / `.destroyForcibly()`|
 * | tiến trình & tắt App| chạy lệnh script dòng lệnh (`Taskkill` trên Windows hoặc `kill -9` trên Linux) rất thủ công.  | để chủ động tắt tiến trình hệ thống một cách an toàn và gọn gàng qua mã Java.|
 */
public class ProcessApiDemo {
    public static void main(String[] args) {
        ProcessHandle current = ProcessHandle.current();
        System.out.println("PID: " + current.pid());
        current.info().command().ifPresent(cmd -> System.out.println("Command: " + cmd));
        System.out.println("Alive: " + current.isAlive());

        System.out.println("Children PIDs:");
        current.children().forEach(ph -> System.out.println(" - " + ph.pid()));

        // 2. Lấy các thông tin chi tiết khác
        ProcessHandle.Info info = current.info();

        info.command().ifPresent(cmd -> System.out.println("Đường dẫn thực thi: " + cmd));
        info.user().ifPresent(user -> System.out.println("Người chạy (User): " + user));
        info.startInstant().ifPresent(start -> System.out.println("Thời gian khởi chạy: " + start));
        info.totalCpuDuration().ifPresent(cpu -> System.out.println("Thời gian CPU đã dùng: " + cpu.toMillis() + " ms"));
    }
}
