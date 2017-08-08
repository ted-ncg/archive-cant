package com.visa.ncg.canteen;

public class Account {
    private final String type;
    private int balance;
    long id;

    public Account(String type, int initialBalance) {
        this.type = type;
        this.balance = initialBalance;
        id = 0;
    }

    public int balance() {
        return balance;
    }

    public void deposit(int amount) {
        balance += amount;
    }

    public void transferTo(Account target, int amount) {
        withdraw(amount);
        target.deposit(amount);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    private void withdraw(int amount) {
        balance -= amount;
    }
}
