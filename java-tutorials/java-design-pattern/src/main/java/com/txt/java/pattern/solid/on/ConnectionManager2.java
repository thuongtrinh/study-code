package com.txt.java.pattern.solid.on;

public class ConnectionManager2 {

    void doConnect(Object inConnection) {
        // Connect to server
        if (inConnection instanceof SqlServerConnection) {
            ((SqlServerConnection) inConnection).doConnect();
        } else if (inConnection instanceof MySqlConnection) {
            ((MySqlConnection) inConnection).doConnect();
        }
    }
}
