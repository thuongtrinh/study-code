package com.txt.java.pattern.solid.i;

/**
 * @comment Interface segregation principle (ISP)
 */
public class Dog implements Runnable, Barkable {

    public void bark() {
        // write code about barking of the dog
    }

    public void run() {
        // write code about running of the dog
    }
}
