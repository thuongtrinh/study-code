package com.txt.java.structure.interfaces;

public class ThirdImpl implements ThirdInterface {

    public boolean isNullOrEmpty(String string) {
        System.out.println("Impl isNullOrEmpty Check: " + string);
        return string == null ? true : false;
    }

    public static void main(String args[]) {
        ThirdImpl obj = new ThirdImpl();
        obj.print("");
        obj.isNullOrEmpty("123");
    }
}
