package com.visa.ncg.canteen.domain;

import com.visa.ncg.canteen.domain.Account;
import org.springframework.stereotype.Service;

@Service
public class AccountService {

    public void withdraw(Account account, int withdrawAmount) {
            if(account.getBalance()-withdrawAmount >= 0 ) {
                account.setBalance(account.getBalance()-withdrawAmount);
            }
    }

    public void transfer(Account sourceAccount, Account targetAccount, int amount) {
        if (sourceAccount.getBalance() > amount && amount > 0) {
            withdraw(sourceAccount, amount);
            targetAccount.setBalance(targetAccount.getBalance() + amount);
        }
        else {
            throw new IllegalArgumentException();
        }
    }
}
