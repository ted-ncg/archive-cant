package com.visa.ncg.canteen;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class SaveFindAccountFromRepositoryTest {

    @Test
    public void saveNewAccoutWithoutIdGeneratesID() throws Exception
    {
        AccountRepository repository = new  AccountRepository();
        Account newAccount = new Account("Canteen", 0);

        newAccount = repository.save(newAccount);

        assertThat(newAccount.id()).isNotEqualTo(0);
    }

    @Test
    public void saveExistingAccountLeaveIdUnchaned() throws Exception
    {
        AccountRepository repository = new  AccountRepository();
        Account newAccount = new Account("Canteen", 0);
        newAccount.setId(3);

        newAccount = repository.save(newAccount);

        assertThat(newAccount.id()).isEqualTo(3);
    }

    @Test
    public void findOneExistingAccountReturnsCorrectAccount() throws Exception
    {
        AccountRepository repository = new  AccountRepository();
        Account newAccount = new Account("Canteen", 5);
        repository.save(newAccount);

        Account account = repository.findOne(newAccount.id());

        assertThat(account).isEqualTo(newAccount);
    }

    @Test
    public  void findTwoExistingAccountsReturnCorrectAccouts() throws Exception
    {
        AccountRepository repository = new  AccountRepository();
        Account newAccountA = new Account("Canteen", 5);
        Account newAccountB = new Account("Savings", 8);
        repository.save(newAccountA);
        repository.save(newAccountB);
        Account[] newAccounts = {newAccountA, newAccountB};

        List<Account> returnedAccounts = repository.findAll();

        assertThat(returnedAccounts).isNotNull().isNotEmpty();
        assertThat(returnedAccounts).containsExactly(newAccounts);
    }
}
