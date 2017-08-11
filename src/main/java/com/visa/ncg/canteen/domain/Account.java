package com.visa.ncg.canteen.domain;

import org.springframework.data.annotation.Id;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
public class Account {
  private String name;
  private int balance;
  private Long id;

  public Account() {
    this.name = "";
  }

  public Account(String name, int initialBalance) {
    this.name = name;
    this.balance = initialBalance;
    this.id = null;
  }
  public String getName() {
    return name;
  }

  public void setName(String name) {this.name = name; }

  public void setBalance(int balance) {
    this.balance = balance;
  }

  public int getBalance() {
    return balance;
  }

  @javax.persistence.Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  public Long getId() {
    return id;
  }

  public void setId(Long id) {
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
