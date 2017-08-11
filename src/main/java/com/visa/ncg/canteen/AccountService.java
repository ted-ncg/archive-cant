package com.visa.ncg.canteen;

import org.springframework.stereotype.Service;

@Service
public class AccountService {



    public void withdraw(Account account, int amount)  {
        //Check balance
        int balance = account.getBalance();
        if(balance > amount) {
            account.setBalance(balance - amount);
        }else {
            throw new IllegalArgumentException();
        }
    }

    public void transfer(Account source, Account target, int amount) {
        if(source.getBalance() > amount) {
            //withdraw from source account
            this.withdraw(source, amount);

            //update/transfer to destination account
            target.setBalance(target.getBalance() + amount);
        }
        else throw new IllegalArgumentException();
    }
}
