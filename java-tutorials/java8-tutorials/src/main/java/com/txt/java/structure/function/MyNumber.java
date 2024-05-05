package com.txt.java.structure.function;

public class MyNumber {

    private long firstNum;
    private long secondNum;

    public MyNumber(long firstNum, long secondNum) {
        this.firstNum = firstNum;
        this.secondNum = secondNum;
    }

    public long process(Calculator calc) {
        return calc.calculate(this.firstNum, this.secondNum);
    }
}
