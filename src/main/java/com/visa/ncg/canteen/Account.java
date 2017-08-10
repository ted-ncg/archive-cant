package com.visa.ncg.canteen;

public class Account {
  private final String name;
  private int balance;
  private Long accountId;

  public Account(String name, int initialBalance) {
    this.name = name;
    this.balance = initialBalance;
    this.accountId = null;
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

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  public Long getId() {
      return accountId;
  }

  public String getName() {
    return name;
  }

  public int getBalance() {
    return balance;
  }

  public void setBalance(int balance) {
    this.balance = balance;
  }
}
