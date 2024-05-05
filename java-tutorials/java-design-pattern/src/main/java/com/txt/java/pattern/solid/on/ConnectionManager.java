package com.txt.java.pattern.solid.on;

public class ConnectionManager {

    /**
     * Do connect to SQL Server
     *
     * @param inConnection
     */
    void doSqlServerConnect(SqlServerConnection inConnection) {
        // Connect to server
        inConnection.doConnect();
    }

    /**
     * Do connect to MySQL Server
     *
     * @param inConnection
     */
    void doMySqlConnect(MySqlConnection inConnection) {
        // Connect to server
        inConnection.doConnect();
    }
}
