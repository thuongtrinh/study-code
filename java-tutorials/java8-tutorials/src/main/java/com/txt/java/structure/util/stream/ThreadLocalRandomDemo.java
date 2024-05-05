package com.txt.java.structure.util.stream;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.ThreadLocalRandom;

public class ThreadLocalRandomDemo {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool();
        TestTask task1 = new TestTask("Task one");
        TestTask task2 = new TestTask("Task two");
        pool.invoke(task1);
        pool.invoke(task2);
    }
}

class TestTask extends ForkJoinTask<String> {
    private static final long serialVersionUID = 1L;
    private String msg = null;

    public TestTask(String msg) {
        this.msg = msg;
    }


    @Override
    protected boolean exec() {
        int i = ThreadLocalRandom.current().nextInt(1, 10);
        System.out.println("ThreadLocalRandom for " + msg + ":" + i);
        return true;
    }

    @Override
    public String getRawResult() {
        return null;
    }

    @Override
    protected void setRawResult(String value) {
    }
}
