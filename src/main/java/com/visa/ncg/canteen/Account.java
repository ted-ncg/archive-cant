package com.visa.ncg.canteen;

public class Account {
  private final String type;
  private int balance;
  long ID;

  public Account(String type, int initialBalance) {
    this.type = type;
    this.balance = initialBalance;
    this.ID = 0L;
  }

  public String getType() {
    return type;
  }

  public int getBalance() {
    return balance;
  }

  public long getID() {
    return ID;
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

  private void withdraw(int amount) {
    balance -= amount;
  }
}
