package com.visa.ncg.canteen;

import org.springframework.stereotype.Service;

@Service
public class AccountService {

    public void withdraw(Account account, int amount){
        if(amount<0) {
            throw new IllegalArgumentException("Withdrawal amount must be positive");
        }

        else if(amount > account.getBalance()){
            throw new IllegalArgumentException("Withdrawal amount is more than the balance");
        }

        else{
            account.setBalance(account.getBalance()-amount);
        }
    }
}
