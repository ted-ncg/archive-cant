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
        //Setup
        Account a1 = new Account("Bank", 50);
        AccountService accountService = new AccountService();

        // Test
        accountService.withdraw(a1, 48);

        //Validate
        assertThat(a1.getBalance()).isEqualTo(2);
    }
}
