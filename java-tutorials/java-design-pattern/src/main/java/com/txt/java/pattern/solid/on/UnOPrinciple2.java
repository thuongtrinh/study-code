package com.txt.java.pattern.solid.on;

/**
 * @Comemnt Not OCP
 */
public class UnOPrinciple2 {

    public static void main(String[] args) {
        ConnectionManager2 connectionPool = new ConnectionManager2();
        connectionPool.doConnect(new MySqlConnection());
        connectionPool.doConnect(new SqlServerConnection());
    }
}
