package com.txt.java.structure.concurrent.completable;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

/**
 * CompletableFutureThenCompose - Khử Phẳng Chuỗi Bất Đồng Bộ Phụ Thuộc (Flattening Dependent Futures) Trong Java 8
 * <p>
 * Minh họa cách sử dụng phương thức .thenCompose() để kết hợp hai tác vụ bất đồng bộ phụ thuộc tuần tự nhau
 * (Lấy thông tin User trước -> Dùng thông tin User đó để lấy tiếp Điểm tín dụng).
 * Giúp giải quyết bài toán lồng nhau của Future (tránh tạo ra kiểu dữ liệu phức tạp CompletableFuture<CompletableFuture<T>>).
 * <p>
 * Các thành phần và tính năng cốt lõi trong Class:
 * - ApiUtil.getUsersDetail(id): Tác vụ bất đồng bộ 1, truy vấn dữ liệu từ UserService và trả về một CompletableFuture<User>.
 * - ApiUtil.getCreditRating(user): Tác vụ bất đồng bộ 2, nhận vào User để tính toán điểm tín dụng thông qua CreditRatingService.
 * - .thenCompose(): Hoạt động tương tự hàm flatMap trong Stream API. Nó làm phẳng kết quả trả về bằng cách giải phóng lớp vỏ bọc Future bên trong.
 * <p>
 * Java version: Java 8+ (2014)
 * <p>
 * Phân biệt bản chất giữa .thenApply() và .thenCompose():
 * <p>
 * | Tiêu chí so sánh | .thenApply() (Tương tự như Map)                        | .thenCompose() (Tương tự như FlatMap)         |
 * |------------------|--------------------------------------------------------|-----------------------------------------------|
 * | 1. Hàm lambda    | Trả về một GIÁ TRỊ THƯỜNG (Một đối tượng dạng Object,   | Trả về một ĐỐI TƯỢNG COMPLETABLEFUTURE MỚI.   |
 * | bên trong nhận vào| String, Integer, Double, v.v.)                         | (Một tác vụ bất đồng bộ độc lập khác)         |
 * | 2. Kiểu dữ liệu  | Nếu hàm nhận vào trả về một Future ngầm, kết quả sẽ bị | Tự động làm phẳng chuỗi. Kết quả trả về gọn   |
 * | trả về cuối cùng | lồng nhau cồng kềnh: CompletableFuture<CompletableFuture<T>> | gàng, không bị lồng: CompletableFuture<T>    |
 * | 3. Mục đích dùng | Biến đổi dữ liệu đồng bộ nhanh chóng ngay trên pipeline| Xâu chuỗi các tác vụ bất đồng bộ phụ thuộc nhau|
 * <p>
 * Ví dụ so sánh kỹ thuật cũ vs hiện đại (Xử lý tác vụ phụ thuộc tuần tự):
 * <p>
 * | Tiêu chí kỹ thuật   | Tiếp cận kiểu cũ (Java 7 về trước với Future)                                                | Tiếp cận hiện đại (Java 8 CompletableFuture thenCompose)                    |
 * |---------------------|----------------------------------------------------------------------------------------------|-----------------------------------------------------------------------------|
 * | 1. Cách phối hợp    | `User user = future1.get();` (Bắt buộc block luồng chính để lấy User)                        | `future1.thenCompose(user -> ApiUtil.getCreditRating(user))`                |
 * | hai tác vụ tuần tự  | `Future<Double> future2 = pool.submit(() -> getRating(user));`                               | Tác vụ thứ hai tự động được kích hoạt và truyền dữ liệu ngầm dưới nền       |
 * |                     | Code bị bẻ gãy thành nhiều đoạn bốc tách dữ liệu thủ công, gây nghẽn luồng xử lý chính.      | ngay khi tác vụ một xong, tạo thành một Pipeline liền mạch (Fluent API).    |
 * | 2. Độ sạch của mã   | Quá nhiều khối lệnh try-catch hoặc các biến Future trung gian nằm rải rác khó quản lý.       | Gom toàn bộ luồng nghiệp vụ đi từ ID -> User -> Credit thành 1 dòng duy nhất|
 */
public class CompletableFutureThenCompose {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        // Using thenCompose()
        CompletableFuture<Double> flattened = ApiUtil.getUsersDetail("1")
                .thenCompose(user -> ApiUtil.getCreditRating(user));
        System.out.println(flattened.get()); // 1.0
    }
}

class User {
    String userId;

    public User(String userId) {
        this.userId = userId;
    }
}

class UserService {
    public static User getUserDetails(String userId) {
        return new User(userId);
    }
}

class CreditRatingService {
    public static Double getCreditRating(User user) {
        return Double.parseDouble(user.userId);
    }
}

class ApiUtil {
    public static CompletableFuture<User> getUsersDetail(String userId) {
        return CompletableFuture.supplyAsync(() -> {
            return UserService.getUserDetails(userId);
        });
    }

    public static CompletableFuture<Double> getCreditRating(User user) {
        return CompletableFuture.supplyAsync(() -> {
            return CreditRatingService.getCreditRating(user);
        });
    }
}
