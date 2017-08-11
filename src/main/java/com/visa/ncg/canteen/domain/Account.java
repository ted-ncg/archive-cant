package com.visa.ncg.canteen.domain;

import com.sun.javafx.beans.IDProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Account {

  private String type;
  private int balance;
  @Id @GeneratedValue(strategy= GenerationType.AUTO)
  private long id;

  public Account(String type, int initialBalance) {
    this.type = type;
    this.balance = initialBalance;
    this.id = 0L;
  }

  public Account(){

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

    @Override
    public String toString(){
        return "id: " + id + ", balance: " + balance;
    }
}


