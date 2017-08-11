package com.visa.ncg.canteen;

public class Account {
  private final String type;
  private int balance;
  long id;

  public Account(String type, int initialBalance) {
    this.type = type;
    this.balance = initialBalance;
    this.id = 0L;
  }

  public String getType() {
    return type;
  }

  public int getBalance() {
    return balance;
  }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void deposit(int amount) {
    balance += amount;
  }

  public void transferTo(Account target, int amount) {
    withdraw(amount);
    target.deposit(amount);
  }

  private void withdraw(int amount) {
    balance -= amount;
  }

  public void setBalance(int balance) {
        this.balance = balance;
    }
}
