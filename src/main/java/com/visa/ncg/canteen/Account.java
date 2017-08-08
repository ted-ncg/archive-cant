package com.visa.ncg.canteen;

public class Account {
  private final String type;
  private int balance;
  public Long ID;

  public Account(String type, int initialBalance) {
    this.type = type;
    this.balance = initialBalance;
    this.ID = null;
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
