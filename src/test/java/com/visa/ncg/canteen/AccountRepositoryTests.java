package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountRepositoryTests {

    //findOne
    //findAll
    //save

    public AccountRepositoryTests() {
    }

    @Test
    public void saveAccountGeneratesAccountId() throws Exception {
        AccountRepository repo = new AccountRepository();
        Account account = new Account("New Account",0,null);
        repo.save(account);
        assertThat(account.getId()).isNotNull();
    }
}
