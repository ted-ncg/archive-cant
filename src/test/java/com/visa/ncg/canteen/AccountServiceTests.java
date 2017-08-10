package com.visa.ncg.canteen;

import org.junit.Test;
import sun.jvm.hotspot.utilities.Assert;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class AccountServiceTests {

    @Test
    public void withdrawAmountLeavingPositiveBalance(){
        Account account = new Account("Checking", 50);
        AccountService accountService = new AccountService();

        accountService.withdraw(account, 10);

        assertThat(account.getBalance()).isEqualTo(40);
    }

    @Test
    public void withdrawAmountGreaterThanAccountBalanceShouldThrowIllegalArgumentException(){
        Account account = new Account("Checking", 50);
        AccountService accountService = new AccountService();

        assertThatThrownBy(() -> { accountService.withdraw(account, 1000); }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void withdrawNegativeBalanceShouldThrowIllegalArgumentException(){
        Account account = new Account("Checking", 50);
        AccountService accountService = new AccountService();

        assertThatThrownBy(() -> { accountService.withdraw(account, -10); }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void depositAmountResultsInCorrectBalance(){
        Account account = new Account("Checking", 50);
        AccountService accountService = new AccountService();

        accountService.deposit(account, 10);

        assertThat(account.getBalance()).isEqualTo(60);
    }

    @Test
    public void depositNegativeBalanceShouldThrowIllegalArgumentException(){
        Account account = new Account("Checking", 50);
        AccountService accountService = new AccountService();

        assertThatThrownBy(() -> { accountService.deposit(account, -10); }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void transferFromSourceWithSufficientFundsDepositsBalanceIntoTarget(){
        //Given
        Account account1 = new Account("Checking", 50);
        Account account2 = new Account("Necessities", 0);
        AccountService accountService = new AccountService();

        accountService.transfer(account1, account2, 30);

        assertThat(account1.getBalance()).isEqualTo(20);
        assertThat(account2.getBalance()).isEqualTo(30);
    }

    @Test
    public void transferFromSourceWithInsufficientFundsThrowsIllegalArgumentException(){
        Account account1 = new Account("Checking", 50);
        Account account2 = new Account("Necessities", 0);
        AccountService accountService = new AccountService();

        assertThatThrownBy(() -> { accountService.transfer(account1, account2, 50); }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void transferNegativeAmountFromSourceThrowsIllegalArgumentException(){
        Account account1 = new Account("Checking", 50);
        Account account2 = new Account("Necessities", 0);
        AccountService accountService = new AccountService();

        assertThatThrownBy(() -> { accountService.transfer(account1, account2, -50); }).isInstanceOf(IllegalArgumentException.class);
    }

}
