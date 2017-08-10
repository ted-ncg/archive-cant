package com.visa.ncg.canteen;

public class Account {
  private final String name;
  private int balance;
  private long id;

  public Account(String name, int initialBalance) {
    this.name = name;
    this.balance = initialBalance;
    this.id = 0;
  }
  public String getName() {
    return name;
  }

  public int getBalance() {
    return balance;
  }

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id=id;
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
