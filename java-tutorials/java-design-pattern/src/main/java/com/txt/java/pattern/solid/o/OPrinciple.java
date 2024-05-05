package com.txt.java.pattern.solid.o;

/**
 * @Comment Open-Closed principle (OCP)
 * @Define Objects or entities should be open for extension, but closed for modification.
 */
public class OPrinciple {

    public static void main(String[] args) {
        ConnectionManager connectionPool = new ConnectionManager();
        connectionPool.doConnect(new MySqlConnection());
        connectionPool.doConnect(new SqlServerConnection());
    }

}
