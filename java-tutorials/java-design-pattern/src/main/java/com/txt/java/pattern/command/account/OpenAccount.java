package com.txt.java.pattern.command.account;

public class OpenAccount implements Command {

    private Account account;

    public OpenAccount(Account account) {
        this.account = account;
    }

    @Override
    public void execute() {
        account.open();
    }
}
