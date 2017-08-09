package com.visa.ncg.canteen;

public class Account {
  private final String name;
  private int balance;
  public Long ID;

  public Account(String name, int initialBalance) {
    this.name = name;
    this.balance = initialBalance;
    this.ID = null;
  }
  public String getName() {
    return name;
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

  private void withdraw(int amount) {
    balance -= amount;
  }
}
