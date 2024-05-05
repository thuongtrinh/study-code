package com.txt.java.structure.util.stream;

import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;

public class RandomAndSecureRandomDemo {

    private static final List<Integer> VALID_PWD_CHARS = new ArrayList<>();

    static {
        IntStream.rangeClosed('0', '9').forEach(VALID_PWD_CHARS::add); // 0-9
        IntStream.rangeClosed('a', 'z').forEach(VALID_PWD_CHARS::add); // a-z
    }

    private static final List<Integer> VALID_PWD_CHARS_2 = new ArrayList<>();

    static {
        IntStream.rangeClosed('0', '9').forEach(VALID_PWD_CHARS_2::add); // 0-9
        IntStream.rangeClosed('A', 'Z').forEach(VALID_PWD_CHARS_2::add); // A-Z
        IntStream.rangeClosed('a', 'z').forEach(VALID_PWD_CHARS_2::add); // a-z
        IntStream.rangeClosed('!', '*').forEach(VALID_PWD_CHARS_2::add); // !-*
    }

    public static void main(String[] args) {
//		System.out.println(VALID_PWD_CHARS); // list ASCII
        RandomDemo();
        SecureRandomDemo();
    }

    private static void SecureRandomDemo() {
        int passwordLength = 8;
        System.out.println("---Generated Password 2: with SecureRandom---");
        for (int i = 0; i < 5; i++) {
            new SecureRandom().ints(passwordLength, 0, VALID_PWD_CHARS_2.size()).map(VALID_PWD_CHARS_2::get)
                    .forEach(s -> System.out.print((char) s));
            System.out.println();
        }
    }

    private static void RandomDemo() {
        int passwordLength = 8;
        System.out.println("---Generated Password---");
        for (int i = 0; i < 5; i++) {
            new Random().ints(passwordLength, 0, VALID_PWD_CHARS.size()).map(VALID_PWD_CHARS::get)
                    .forEach(s -> System.out.print((char) s));
            System.out.println();
        }
    }

}
