package com.visa.ncg.canteen.domain;

import com.visa.ncg.canteen.data.AccountRepository;
import org.springframework.stereotype.Service;

/**
 * Created by nedsouza on 8/10/2017.
 */
@Service
public class AccountService {
    AccountRepository accountRepository;

    public AccountService( AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public AccountService (){}

    public AccountRepository getAccountRepository() {
        return accountRepository;
    }

    public void setAccountRepository(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public void withdraw(Account account1, int withdrawAmount) {
        // Check for invalid input
        if ( withdrawAmount > 0 ) {
            account1.setBalance(account1.getBalance()-withdrawAmount);
            accountRepository.save(account1);
        }
    }


    public void transfer(Account sourceAccount, Account targetAccount, int transferAmount) {
        withdraw(sourceAccount, transferAmount);
        targetAccount.setBalance(targetAccount.getBalance() + transferAmount);
        accountRepository.save(targetAccount);
    }
}
