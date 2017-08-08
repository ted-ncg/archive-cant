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
        AccountRepository accountRepository = new AccountRepository();
        Account account = new Account("New Account",0);
        accountRepository.save(account);
        assertThat(account.getId()).isNotNull();
    }

    @Test
    public void saveExistingAccountReturnsSameId() throws Exception {
        AccountRepository accountRepository = new AccountRepository();
        Account account = new Account("New Account",0);
        accountRepository.save(account);

        Long expectedAccountId = account.getId();
        accountRepository.save(account);
        Long existingAccountId = account.getId();

        assertThat(existingAccountId).isEqualTo(expectedAccountId);
    }

    @Test
    public void saveTwoUniqueAccountsReturnsUniqueIds() throws Exception {
        AccountRepository accountRepository = new AccountRepository();
        Account account1 = new Account("Account 1", 0);
        Account account2 = new Account("Account 2", 0);

        accountRepository.save(account1);
        accountRepository.save(account2);

        assertThat(account1.getId()).isNotEqualTo(account2.getId());
    }

    @Test
    public void findOneAccountReturnsAccountWithThatId() throws Exception {
        AccountRepository accountRepository = new AccountRepository();
        Account account = new Account( "Account", 0);

        accountRepository.save(account);
        Long expectedAccountId = account.getId();

        Account foundAccount = accountRepository.findOne(expectedAccountId);

        assertThat(foundAccount.getId()).isEqualTo(expectedAccountId);
    }
}
