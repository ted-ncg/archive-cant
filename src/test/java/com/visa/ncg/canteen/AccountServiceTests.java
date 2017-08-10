package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by nedsouza on 8/10/2017.
 */
public class AccountServiceTests {
    AccountRepository accountRepository;

    @Test
    public void ifBalanceGreaterThanAmountWithdrawDeductBalance() throws Exception {

        Account account1 = new Account("Necessities", 10);
        AccountService accountService = new AccountService(accountRepository);

        accountService.withdraw(account1, 6);

        assertThat(account1.getBalance())
                .isEqualTo(4);
    }

    @Test
    public void ifBalanceEqualToAmountWithdrawFailsToDeductBalance() throws IllegalArgumentException{

        Account account1 = new Account("Necessities", 10);
        AccountService accountService = new AccountService(accountRepository);

        int originaBalance = account1.getBalance();
        accountService.withdraw(account1, 10);

        assertThat(account1.getBalance())
                .isEqualTo(originaBalance);
    }

    @Test
    public void ifBalanceLessThanAmountWithdrawFailsToDeductBalance() throws IllegalArgumentException{

        Account account1 = new Account("Necessities", 10);
        AccountService accountService = new AccountService(accountRepository);

        int originaBalance = account1.getBalance();
        accountService.withdraw(account1, 11);

        assertThat(account1.getBalance())
                .isEqualTo(originaBalance);
    }

    @Test
    public void ifAmountInvalidFailsToDeductBalance() throws IllegalArgumentException {

        Account account1 = new Account("Necessities", 10);
        AccountService accountService = new AccountService(accountRepository);

        int originaBalance = account1.getBalance();
        accountService.withdraw(account1, -1);

        assertThat(account1.getBalance())
                .isEqualTo(originaBalance);
    }

    @Test
    public void transferSuccessfulIfTargetAccountIsCreditedAndSourceAccountIsDebited() throws IllegalArgumentException {
        Account sourceAccount = new Account("Bank", 100);
        Account targetAccount = new Account("Necessities", 40);

        AccountService accountService = new AccountService(accountRepository);

        accountService.transfer(sourceAccount,targetAccount,20);

        assertThat(targetAccount.getBalance()).isEqualTo(60);
        assertThat(sourceAccount.getBalance()).isEqualTo(80);

    }



}
