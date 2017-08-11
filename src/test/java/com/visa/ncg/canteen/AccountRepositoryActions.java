package com.visa.ncg.canteen;

import org.junit.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by nedsouza on 8/8/2017.
 */
public class AccountRepositoryActions {

    @Test
    public void saveAccountIDIfNotNull() throws Exception {

        Account newParent = new Account("Necessities", 10);
        AccountRepository accountRepository = new AccountRepository();

        assertThat(accountRepository.save(newParent))
                .isNotEqualTo(0L);
    }

    @Test
    public void findAccountIDIfNotExists() throws Exception {
        Account newParent = new Account("Necessities", 10);
        AccountRepository accountRepository = new AccountRepository();

        assertThat(accountRepository.find(newParent.id))
                .isEqualTo(null);
    }

    @Test
    public void findAccountIDIfExists() throws Exception {
        Account newParent = new Account("Necessities", 10);
        AccountRepository accountRepository = new AccountRepository();

        accountRepository.save(newParent);

        assertThat(accountRepository.find(newParent.id))
                .isNotEqualTo(null);
    }

    @Test
    public void findAll() throws Exception {
        AccountRepository accountRepository = new AccountRepository();

        List<Account> accountList = accountRepository.findAll();
        assertThat(accountList).isNotEmpty();
    }

}