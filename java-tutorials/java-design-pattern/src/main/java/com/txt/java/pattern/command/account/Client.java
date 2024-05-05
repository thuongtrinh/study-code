package com.txt.java.pattern.command.account;

public class Client {
    public static void main(String[] args) {
        Account account = new Account("thgtx");

        Command open = new OpenAccount(account);
        Command close = new CloseAccount(account);
        BankApp bankApp = new BankApp(open, close);

        bankApp.clickOpenAccount();
        bankApp.clickCloseAccount();
    }
}
