package com.visa.ncg.canteen;

import org.junit.Test;

import java.util.ArrayList;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by djose on 8/8/17.
 */
public class AccountRepositoryTest {

    @Test
    public void findAccountFromRepository() throws Exception
    {
        AccountRepository repo = new AccountRepository();
        Account acnt = new Account("Necessities",10,12345676);
        repo.save(acnt);

        assertThat(acnt).isEqualTo(repo.findOne(12345676));
    }

    @Test
    public void saveAccountToRepository() throws Exception{
        AccountRepository repo = new AccountRepository();

        Account acnt = new Account("Necessities",10);
        repo.save(acnt);
        Account acnt1 = new Account("Necessities",10);
        repo.save(acnt1);

        assertThat(repo.findOne(10001)).isEqualTo(acnt1);

    }


    @Test
    public void updateAccoutsIsInRepository() throws Exception{
        AccountRepository repo = new AccountRepository();

        Account acnt = new Account("Necessities",10);
        repo.save(acnt);
        Account acnt1 = new Account("Necessities",20, 1);
        repo.save(acnt1);

        assertThat(repo.findOne(1)).isEqualTo(acnt1);

    }

    @Test
    public void checkUniqunessOfIds() throws Exception{
        AccountRepository repo = new AccountRepository();

        Account acnt = new Account("Necessities",10);
        repo.save(acnt);
        Account acnt1 = new Account("Necessities",20);
        repo.save(acnt1);

        ArrayList<Account> accountList = new ArrayList<>();
        accountList = repo.findAll();
        assertThat(accountList.get(0).getId()).isNotEqualTo(accountList.get(1).getId());

    }

    @Test
    public void findAllAccountsOnRepository() throws Exception
    {
        AccountRepository repo = new AccountRepository();

        Account acnt = new Account("Necessities",10);
        repo.save(acnt);
        Account acnt1 = new Account("Necessities",10);
        repo.save(acnt1);

        ArrayList<Account> accountList = new ArrayList<>();
        accountList.add(acnt);
        accountList.add(acnt1);

        assertThat(repo.findAll()).isEqualTo(accountList);
    }



}
