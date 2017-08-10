package com.visa.ncg.canteen;

/**
 * Created by nedsouza on 8/10/2017.
 */
public class AccountService {
    AccountRepository accountRepository;

    public AccountService( AccountRepository accountRepository) {
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
