package com.txt.java.pattern.solid.on;

/**
 * @Comemnt Not OCP
 */
public class UnOPrinciple {

    public static void main(String[] args) {
        ConnectionManager connectionPool = new ConnectionManager();
        connectionPool.doMySqlConnect(new MySqlConnection());
        connectionPool.doSqlServerConnect(new SqlServerConnection());
    }
}
