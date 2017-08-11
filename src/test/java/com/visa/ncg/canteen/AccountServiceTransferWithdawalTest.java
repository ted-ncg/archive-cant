package com.visa.ncg.canteen;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class AccountServiceTransferWithdawalTest {

    @Test
    public void withdrawHasFundsSuccess(){

        AccountService accountService = new AccountService();
        Account account= new Account("Bank", 10);

        accountService.withdraw(account, 9);

        assertThat(account.getBalance()).isEqualTo(1);
    }

    @Test
    public void withdrawHasFundsFailure() throws Exception{

        AccountService accountService = new AccountService();
        Account account = new Account("Bank", 10);


        assertThatThrownBy(() -> accountService.withdraw(account, 10))
                .isInstanceOf(IllegalArgumentException.class);

        assertThat(account.getBalance()).isEqualTo(10);
    }

    @Test
    public void transferHasFundSuccess() throws Exception
    {
        AccountService accountService = new AccountService();
        Account source = new Account("Bank", 10);
        Account target = new Account("Bank", 20);

        accountService.transfer(source,target,9);

        assertThat(source.getBalance()).isEqualTo(1);
        assertThat(target.getBalance()).isEqualTo(29);
    }

    @Test
    public void transferHasNoFundFailure()
    {
        AccountService accountService = new AccountService();
        Account source= new Account("Bank", 10);
        Account target= new Account("Bank", 20);

        assertThatThrownBy(() -> accountService.transfer(source, target, 10))
                .isInstanceOf(IllegalArgumentException.class);

        assertThat(source.getBalance()).isEqualTo(10);
        assertThat(target.getBalance()).isEqualTo(20);
    }


}
