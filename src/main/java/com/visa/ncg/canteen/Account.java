package com.visa.ncg.canteen;

public class Account {
    private final String type;
    private int balance;
    private long id;

    public Account(String type, int initialBalance) {
        this.type = type;
        this.balance = initialBalance;
        id = 0;
    }

    public int getBalance() {
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

    protected void setId(long id) {
        this.id = id;
    }
    public String getType() {
        return type;
    }
    private void withdraw(int amount) {
        balance -= amount;
    }
}
