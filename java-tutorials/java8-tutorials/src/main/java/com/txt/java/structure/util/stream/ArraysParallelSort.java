package com.txt.java.structure.util.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;

import com.txt.java.structure.model.User;

public class ArraysParallelSort {

    public static void main(String[] args) {
        parallelSortWithPrimitiveDataType();
        ParallelSortWithComparable();
    }

    private static void parallelSortWithPrimitiveDataType() {
        System.out.println("I. parallelSortWithPrimitiveDataType");
        int[] num1 = {3, 6, 2, 10, 4, 1, 7};
        System.out.println("--Sort complete Integer array--");
        Arrays.parallelSort(num1);

        System.out.println(Arrays.toString(num1));

        IntConsumer printInt = i -> System.out.print(i + " ");
        Arrays.stream(num1).forEach(printInt);

        System.out.println("\n--Sort Integer array from index 1 to 5--");
        int[] num2 = {3, 6, 2, 10, 4, 1, 7};
        Arrays.parallelSort(num2, 1, 5);
        Arrays.stream(num1).forEach(printInt);

        double[] db1 = {3.5, 1.2, 6.7, 8.9, 0.6, 2.3, 5.5};
        System.out.println("\n--Sort complete Double array--");
        Arrays.parallelSort(db1);
        DoubleConsumer printDB = d -> System.out.print(d + " ");
        Arrays.stream(db1).forEach(printDB);

        System.out.println("\n--Sort Double array from index 1 to 5--");
        double[] db2 = {3.5, 1.2, 6.7, 8.9, 0.6, 2.3, 5.5};
        Arrays.parallelSort(db2, 1, 5);
        Arrays.stream(db2).forEach(printDB);
    }

    private static void ParallelSortWithComparable() {
        System.out.println("\n\nII. ParallelSortWithComparable");
        List<User> lstUser = User.getUsers();
        User[] users = new User[lstUser.size()];
        users = lstUser.toArray(users);

        System.out.println("--Sort complete array--");
        Arrays.parallelSort(users);
        Consumer<User> printUser = u -> System.out.println(u.getName() + "-" + u.getAge());
        Arrays.stream(users).forEach(printUser);

        System.out.println("--Sort array from index 1 to 4--");
        users = User.getUsers().toArray(users);
        Arrays.parallelSort(users, 1, 4);
        Arrays.stream(users).forEach(printUser);
    }
}
