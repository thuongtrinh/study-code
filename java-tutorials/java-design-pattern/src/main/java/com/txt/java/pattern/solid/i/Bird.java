package com.txt.java.pattern.solid.i;

/**
 * @comment Interface segregation principle (ISP)
 */
public class Bird implements Flyable, Runnable {

    public void run() {
        // write code about running of the bird
    }

    public void fly() {
        // write code about flying of the bird
    }
}
