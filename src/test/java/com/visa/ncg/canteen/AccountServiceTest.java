package com.visa.ncg.canteen;

import org.junit.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.apache.coyote.http11.Constants.a;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

/**
 * Created by djose on 8/10/17.
 */
public class AccountServiceTest {

    @Test
    public void testWithdrawFromAccount() throws Exception
    {
        Account account = new Account("Necessities",100, 12);
        AccountService service = new AccountService();
        service.withdraw(account, 20);

        assertThat(account.getBalance()).isEqualTo(80);

    }

    /*
    @Test
    public void testAccountStaysAboveZeroAfterWithdraw() throws Exception
    {
        Account account = new Account("Necessities", 100, 13);
        AccountService service = new AccountService();
        service.withdraw(account, 100);

        assertThat(account.getBalance()).isEqualTo(100);

    }

*/

    @Test
    public void testTransferFromAccount() throws Exception
    {
        Account source = new Account("Necessities", 100, 12);
        Account target = new Account("Necessities", 10, 11);

        AccountService service = new AccountService();
        service.transfer(source, target, 40);

        assertThat(target.getBalance()).isEqualTo(50);
        assertThat(source.getBalance()).isEqualTo(60);

    }

    /*
    @Test
    public void sourceStaysAboveZeroAfterTransfer() throws Exception
    {
        Account source = new Account("Necessities", 100, 12);
        Account target = new Account("Necessities", 10, 11);

        AccountService service = new AccountService();
        service.transfer(source, target, 110);


        assertThat(source.getBalance()).isEqualTo(100);

    }
*/

    @Test
    public void withdrawThrowsExceptionWhenExceedingBalance()
    {
        Account account = new Account("Necessities", 100, 13);
        AccountService service = new AccountService();



        assertThatThrownBy(() -> {  service.withdraw(account, 100);}).isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    public void transferThrowsExceptionWhenExceedingBalance()
    {
        Account source = new Account("Necessities", 100, 12);
        Account target = new Account("Necessities", 10, 11);

        AccountService service = new AccountService();


        assertThatThrownBy(() -> {   service.transfer(source, target, 110);}).isInstanceOf(IllegalArgumentException.class);

    }
}
