package com.visa.ncg.canteen;

public class Account {
  private final String type;
  private int balance;
  private Long accountId;

  public Account(String type, int initialBalance) {
    this.type = type;
    this.balance = initialBalance;
    this.accountId = null;
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

  public void setAccountId(Long accountId) {
    this.accountId = accountId;
  }

  public Long getId() {
        return accountId;
    }
}
