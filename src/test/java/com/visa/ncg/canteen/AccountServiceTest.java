package com.visa.ncg.canteen;


import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class AccountServiceTest {

    @Test(expected = IllegalArgumentException.class)
    public void withdrawAmountThrowsExceptionIfNegative(){
        // Setup
        Account a1 = new Account("Bank", 50);
        AccountService accountService = new AccountService();

        // Test
        accountService.withdraw(a1, -20);

        // Validate
    }

    @Test(expected = IllegalArgumentException.class)
    public void withdrawAmountIsGreaterThanBalanceThrowsException(){
        //Setup
        Account a1 = new Account("Bank", 50);
        AccountService accountService = new AccountService();

        // Test
        accountService.withdraw(a1, 52);

        //Validate
    }

    @Test
    public void withdrawAmountLessThanBalanceReducesAccountBalance(){
        // Setup
        Account a1 = new Account("Bank", 50);
        AccountService accountService = new AccountService();

        // Test
        accountService.withdraw(a1, 48);

        //Validate
        assertThat(a1.getBalance()).isEqualTo(2);
    }

    @Test(expected = IllegalArgumentException.class)
    public void depositThrowsExceptionWhenAmountIsNegative(){
        // Setup
        Account a1 = new Account("bank", 100);
        AccountService accountService = new AccountService();

        // Test
        accountService.deposit(a1, -10);

        // Validate
    }

    @Test
    public void depositIncreasesBalance(){
        // Setup
        Account a1 = new Account("bank", 0);
        AccountService accountService = new AccountService();

        // Test
        accountService.deposit(a1, 20);

        // Validate
        assertThat(a1.getBalance()).isEqualTo(20);
    }

    @Test
    public void transferIncreasesTargetBalanceAndDecreasesSourceBalance() throws Exception{
        // Setup
        Account a1 = new Account("bank", 100);
        Account a2 = new Account("bank", 0);
        AccountService accountService = new AccountService();

        // Test
        accountService.transfer(a1, a2, 20);

        // Validate
        assertThat(a1.getBalance()).isEqualTo(80);
        assertThat(a2.getBalance()).isEqualTo(20);
    }
}
