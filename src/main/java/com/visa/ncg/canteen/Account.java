package com.visa.ncg.canteen;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {
  private String name;
  private int balance;

  @Id
  @GeneratedValue(strategy= GenerationType.AUTO)
  private Long id;

  public Account() {

  }

  public Account(String name, int initialBalance) {
    this.name = name;
    this.balance = initialBalance;
    this.id = null;
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

  public void setId(Long id) {
    this.id = id;
  }

  public Long getId() {
      return id;
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
