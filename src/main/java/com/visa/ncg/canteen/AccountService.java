package com.visa.ncg.canteen;

import org.springframework.stereotype.Service;

/**
 * Created by djose on 8/10/17.
 */

@Service
public class AccountService {


    public void withdraw(Account account, int amount) {
        if(account.getBalance() > amount) {
            account.setBalance(-amount);
        }
        else

        {
            throw new IllegalArgumentException();
        }
    }

    public void transfer(Account source, Account target, int amount) {

        if(source.getBalance() > amount) {
            target.setBalance(amount);
            source.setBalance(-amount);
        }
        else
        {
            throw new IllegalArgumentException();
        }
    }
}
