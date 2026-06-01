package com.txt.java.structure.function;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

import com.txt.java.structure.model.Student;

/**
 * AcceptEitherDemo - Demo Consumer và ForEach của Java 8
 * <p>
 * Duyệt qua các phần tử của Collection/Array và xử lý hành động (Action) bằng Functional Interface.
 * <p>
 * Tính năng chính:
 * - ConsumerForEach: Sử dụng Iterable.forEach() kết hợp Consumer lambda để duyệt List Student.
 * - Primitive Consumer: Sử dụng IntConsumer, LongConsumer, DoubleConsumer với Arrays.stream() để xử lý mảng nguyên thủy.
 * <p>
 * Java version: Java 8+ (2014)
 * <p>
 * Tốt hơn Java cũ (Java 7-) gì?
 * <p>
 * | Java 7- (Cũ)                       | Java 8+ (Consumer & Stream)            |
 * |------------------------------------|----------------------------------------|
 * | Dùng vòng lặp for/foreach cơ bản   | Dùng Iterable.forEach() gọn gàng       |
 * | Code dài dòng (Boilerplate)        | Dùng Lambda expression / Method Ref    |
 * | Tách biệt logic lặp khó khăn       | Tách riêng cơ chế lặp và hành động     |
 * | Autoboxing tốn memory cho primitive| Primitive Consumer chạy trực tiếp gốc  |
 * | Khó chuyển đổi sang chạy song song | Dễ dàng chuyển sang parallelStream()   |
 *
 * <p>
 * Lợi ích của Consumer & ForEach:
 * - Code ngắn gọn, dễ đọc, viết trên một dòng (Fluent API).
 * - Tránh ép kiểu ngầm định (No Autoboxing) cho các kiểu dữ liệu nguyên thủy như int, long, double.
 * - Hỗ trợ lập trình hàm (Functional Programming) giúp mã nguồn linh hoạt hơn.
 */

public class ConsumerForEach {

    public static void main(String[] args) {
        com.txt.java.structure.model.Student s1 = new com.txt.java.structure.model.Student("Ram", "A", 20);
        com.txt.java.structure.model.Student s2 = new com.txt.java.structure.model.Student("Shyam", "B", 22);
        com.txt.java.structure.model.Student s3 = new com.txt.java.structure.model.Student("Mohan", "A", 22);
        com.txt.java.structure.model.Student s4 = new com.txt.java.structure.model.Student("Mahesh", "C", 20);
        com.txt.java.structure.model.Student s5 = new com.txt.java.structure.model.Student("Krishna", "B", 21);
        List<com.txt.java.structure.model.Student> list = Arrays.asList(s1, s2, s3, s4, s5);

        // Creating instance of Consumer functional interface
        Consumer<com.txt.java.structure.model.Student> style = (Student s) -> System.out.println("Name:" + s.getName() + " and Age:" + s.getAge());
        // first way using Consumer
        list.forEach(style);

        // second way using method reference
//		list.forEach(Student::printData);

        // third way using lambda expression
//		list.forEach(s -> s.printData());

        System.out.println("--IntConsumer--");
        int[] intNum = {3, 5, 6, 10, 15};
        IntConsumer intCon = i -> System.out.print(i + " ");
        Arrays.stream(intNum).forEach(intCon);

        System.out.println("\n--LongConsumer--");
        long[] longNum = {13l, 9l, 6l, 10l, 15l};
        LongConsumer longCon = l -> System.out.print(l + " ");
        Arrays.stream(longNum).forEach(longCon);

        System.out.println("\n--DoubleConsumer--");
        double[] dbNum = {13.4d, 9.1d, 6.5d, 10.3d, 15.3d};
        DoubleConsumer dbCon = d -> System.out.print(d + " ");
        Arrays.stream(dbNum).forEach(dbCon);
    }
}
