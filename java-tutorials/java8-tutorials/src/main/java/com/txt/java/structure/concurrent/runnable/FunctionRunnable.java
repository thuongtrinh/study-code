package com.txt.java.structure.concurrent.runnable;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.function.Consumer;

import com.txt.java.structure.model.Book;

/**
 * FunctionRunnable - Tối Ưu Hóa Runnable Và Callable Bằng Cú Pháp Lambda Trong Java 8
 * <p>
 * Triển khai các tác vụ đa luồng nền tảng (Thread, Executor) thông qua việc kết hợp Functional Interface và Stream API.
 * <p>
 * Tính năng chính:
 * - Lambda hóa SAM Interfaces: Chuyển đổi toàn bộ cú pháp khởi tạo Runnable và Callable từ Anonymous Class sang biểu thức Lambda siêu gọn.
 * - Tích hợp lồng chức năng (Nested Lambda): Nhúng trực tiếp Consumer và vòng lặp Iterable.forEach() vào bên trong phương thức chạy của Runnable.
 * - Method Reference (Book::print): Tham chiếu trực tiếp đến phương thức in dữ liệu của đối tượng để thay thế hoàn toàn biểu thức lambda tường minh.
 * - Stream API thu gom số nguyên: Sử dụng stream().mapToInt(n -> n).sum() để tính tổng mảng số nguyên một cách trực quan trong luồng Callable.
 * <p>
 * Java version: Java 8+ (2014)
 * <p>
 * Tốt hơn Java cũ (Java 7-) gì?
 * <p>
 * | Đặc tính cấu trúc                  | Java 7- (Cũ)                           | Java 8+ (Lambda & Method Reference)     |
 * |------------------------------------|----------------------------------------|-----------------------------------------|
 * | Cú pháp triển khai tác vụ          | Phải viết Anonymous Class rất cồng kềnh| Sử dụng biểu thức Lambda viết trên 1 dòng|
 * | Cách duyệt tập hợp trong luồng     | Sử dụng vòng lặp for/foreach truyền thống| Sử dụng books.forEach() kết hợp Consumer |
 * | Tham chiếu đến hàm có sẵn          | Viết hàm nặc danh gọi lại phương thức  | Sử dụng cú pháp Class::method cực kỳ sạch|
 * | Tính tổng dữ liệu số trong luồng   | Phải tạo biến tạm accumulator và lặp   | Sử dụng mapToInt().sum() của IntStream  |
 * | Độ sạch của mã nguồn (Readability) | Code bị loãng bởi các từ khóa khai báo | Tập trung trực tiếp vào hành động thực thi|
 *
 * <p>
 * Lợi ích của cú pháp Java 8 với đa luồng:
 * - Giảm thiểu tối đa số lượng class trung gian nặc danh được tạo ra khi biên dịch (giúp file .class gọn nhẹ hơn).
 * - Kết hợp mượt mà các tư duy lập trình hàm (Functional Programming) vào kiến trúc xử lý bất đồng bộ truyền thống của Java.
 * <p>
 * Ví dụ so sánh:
 * Java 7: Runnable r = new Runnable() { @Override public void run() { System.out.println("Hello"); } }; // Tốn 5 dòng mã nguồn
 * Java 8: Runnable r = () -> System.out.println("Hello"); // Thu gọn hoàn chỉnh cấu trúc chỉ trên 1 dòng duy nhất
 */

public class FunctionRunnable {

    public static void main(String[] args) {
        // Runnable hello World
        Runnable r = () -> System.out.println("Hello World!");
//		r = new Runnable() {
//			@Override
//			public void run() {
//				System.out.println("Hello World!");
//			}
//		};

        Thread th = new Thread(r);
        th.start();

        // Functional
        List<Book> books = Arrays.asList(new Book(10, "AAA"), new Book(20, "BBB"), new Book(30, "XXX"),
                new Book(15, "ZZZ"));

//		r = () -> {
//			Consumer<Book> consumerBook = new Consumer<Book>() {
//				@Override
//				public void accept(Book b) {
//					System.out.println("Name: " + b.getName() + ", price: " + b.getPrice());
//				}
//			};
//			
//			books.forEach(consumerBook);
//		};

        r = () -> {
            Consumer<Book> consumerBook = (b) -> System.out
                    .println("Name: " + b.getName() + ", price: " + b.getPrice());
            books.forEach(consumerBook);
        };

        Thread thread1 = new Thread(r);
        thread1.start();

        // Runnable
        Runnable r2 = new Runnable() {

            @Override
            public void run() {
                System.out.println("-----------");
                books.forEach(Book::print);
            }
        };

        thread1 = new Thread(r2);
        thread1.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Run the Runnable instance using ExecutorService
        System.out.println("\n------Run the Runnable instance using ExecutorService------");
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        Runnable r3 = () -> books.forEach(Book::print);
        executorService.execute(r3);
        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Java 8 Callable Lambda Example with Argument
        System.out.println("\n------Java 8 Callable Lambda Example with Argument------");
        List<Integer> integers = Arrays.asList(1, 2, 3, 4, 5);

        Callable<Integer> callableObj = new Callable<Integer>() {

            @Override
            public Integer call() throws Exception {
                return integers.stream().mapToInt(n -> n).sum();
            }
        };

        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService2.submit(callableObj);
        try {
            System.out.println(future.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("------Finish------");
    }
}
