package com.visa.ncg.canteen;

public class Account {


  private final String type;
  private int balance;
  private long id;

  public String getType() {
    return type;
  }

  public long getId()
  {
    return id;
  }

  public void setId(long id)
  {
    this.id = id;
  }

  public Account(String type, int initialBalance, long id)
  {
    this.type = type;
    this.balance = initialBalance;
    this.id = id;
  }

  public Account(String type, int initialBalance)
  {
    this.type = type;
    this.balance = initialBalance;
    this.id = 0;
  }

  public int getBalance()
  {
    return balance;
  }

  public void setBalance(int amount)
  {
    balance += amount;
  }

  public void transferTo(Account target, int amount)
  {
    withdraw(amount);
    target.setBalance(amount);
  }

  private void withdraw(int amount)
  {
    balance -= amount;
  }
}
