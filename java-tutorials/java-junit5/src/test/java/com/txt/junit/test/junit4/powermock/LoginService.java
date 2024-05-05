package com.txt.junit.test.junit4.powermock;

public class LoginService {

    private static final GoogleService GOOGLE_SERVICE = new GoogleService();

    private final String message;

    public LoginService(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
