package com.visa.ncg.canteen;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

    public void withdraw(Account account, int balance) {

        int initialAccountBalance = account.getBalance();

        if(initialAccountBalance > balance && balance > 0) {
            account.setBalance(initialAccountBalance - balance);
        } else{
            throw new IllegalArgumentException("Broken Account Service transfer");
        }

    }

    public void deposit(Account account, int balance) {
        if(balance <= 0){
            throw new IllegalArgumentException("Can't depsoit zero or negative amount");
        }

        account.setBalance(account.getBalance() + balance);
    }

    public void transfer(Account source, Account target, int amount) {
        withdraw(source, amount);
        deposit(target, amount);
    }
}
