package com.visa.ncg.canteen;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class AccountServiceTest {

    AccountService service = new AccountService();

    @Test
    public void withdrawFromAccountWithSufficientBalance() {
        Account account = new Account("savings", 100);
        service.withdraw(account, 50);
        assertThat(account.getBalance()).isEqualTo(50);
    }

    @Test
    public void withdrawFromAccountWithInufficientBalance() {
        Account account = new Account("savings", 100);
        service.withdraw(account, 200);
        assertThat(account.getBalance()).isEqualTo(100);
    }

    @Test
    public void withdrawFromAccountLeavingZeroBalance() {
        Account account = new Account("savings", 100);
        service.withdraw(account, 100);
        assertThat(account.getBalance()).isEqualTo(0);
    }

    @Test
    public void transferFromAccountLeavingSufficientBalance()
    {
        Account account1 = new Account("Savings",100);
        Account account2 = new Account("Checkings", 100);
        service.transfer(account1,account2, 50);
        assertThat(account1.getBalance()).isEqualTo(50);
        assertThat(account2.getBalance()).isEqualTo(150);
    }

    @Test
    public void transferFromAccountWithoutSufficientBalanceThrowsException()
    {
        Account account1 = new Account("Savings",100);
        Account account2 = new Account("Checkings", 100);
        try {
            service.transfer(account1, account2, 150);
        }
        catch (IllegalArgumentException e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    public void transferFromAccountLeavingMinimumBalance()
    {
        Account account1 = new Account("Savings",100);
        Account account2 = new Account("Checkings", 100);
        service.transfer(account1,account2, 99);
        assertThat(account1.getBalance()).isEqualTo(1);
        assertThat(account2.getBalance()).isEqualTo(199);
    }

    @Test
    public void transferNegativeAmountThrowsException() {
        Account account1 = new Account("Savings",100);
        Account account2 = new Account("Checkings", 100);
        try {
            service.transfer(account1, account2, -100);
        }
        catch (IllegalArgumentException e) {
            assertThat(e).isInstanceOf(IllegalArgumentException.class);
        }
    }
}
