package com.visa.ncg.canteen;

public class Account {
    private final String name;
    private int balance;
    private long id;

    public Account(String name, int initialBalance) {
        this.name = name;
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

    public String getName() {
        return name;
    }

    private void withdraw(int amount) {
        balance -= amount;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }
}
