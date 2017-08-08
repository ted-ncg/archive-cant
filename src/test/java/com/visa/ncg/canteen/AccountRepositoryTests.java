package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountRepositoryTests {

    //findOne
    //findAll

    public AccountRepositoryTests() {
    }

    @Test
    public void saveAccountGeneratesAccountId() throws Exception {
        AccountRepository repo = new AccountRepository();
        Account account = new Account("New Account",0,null);
        repo.save(account);
        assertThat(account.getId()).isNotNull();
    }

    @Test
    public void saveExistingAccountReturnsSameId() throws Exception {
        AccountRepository repo = new AccountRepository();
        Account account = new Account("New Account",0,null);
        repo.save(account);

        Long expectedAccountId = account.getId();
        repo.save(account);
        Long existingAccountId = account.getId();

        assertThat(existingAccountId).isEqualTo(expectedAccountId);
    }

    @Test
    public void saveTwoUniqueAccountsReturnsUniqueIds() throws Exception {
        AccountRepository repo = new AccountRepository();
        Account account1 = new Account("Account 1", 0, null);
        Account account2 = new Account("Account 2", 0, null);

        repo.save(account1);
        repo.save(account2);

        assertThat(account1.getId()).isNotEqualTo(account2.getId());
    }
}
