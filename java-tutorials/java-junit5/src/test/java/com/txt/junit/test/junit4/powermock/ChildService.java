package com.txt.junit.test.junit4.powermock;

public class ChildService extends BaseService {

    private final String message;

    public ChildService(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
