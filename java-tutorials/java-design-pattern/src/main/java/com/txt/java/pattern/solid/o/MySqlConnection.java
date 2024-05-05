package com.txt.java.pattern.solid.o;

public class MySqlConnection extends Connection {

    @Override
    public void doConnect() {
        System.out.println("Connect to MySQL Server");
    }

}
