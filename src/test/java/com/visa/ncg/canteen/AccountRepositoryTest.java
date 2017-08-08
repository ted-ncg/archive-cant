package com.visa.ncg.canteen;

import org.junit.Test;
import sun.jvm.hotspot.utilities.Assert;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class AccountRepositoryTest {



    @Test
    public void saveAccountReturnsNewObjectWithID() {
        //Setup
        AccountRepository accountRepository= new AccountRepository();
        Account newAccount = new Account("NecessityAccount", 50);

        //Test
        accountRepository.save(newAccount);

        //Validate
        assertThat(newAccount.getId()).isNotEqualTo(0);
    }

    @Test
    public void saveAccountReturnsNewObjectWithIDIncremented(){
        //Setup
        AccountRepository accountRepository= new AccountRepository();
        Account newAccount = new Account("necessityAccount", 60);
        Account anotherAcc = new Account("NecessityAccount", 50);

        //Test
        accountRepository.save(newAccount);
        accountRepository.save(anotherAcc);

        //Validate
        assertThat(newAccount.getId()).isNotEqualTo(anotherAcc.getId());
    }

    @Test
    public void saveAccountReturnsSameObjectIfIDProvided(){
        //Setup
        AccountRepository accountRepository= new AccountRepository();
        Account newAccount = new Account("necessityAccount", 80);

        //Test
        accountRepository.save(newAccount);
        long prevId = newAccount.getId();
        accountRepository.save(newAccount);

        //Validate
        assertThat(newAccount.getId()).isEqualTo(prevId);
    }

    @Test
    public void findOneAccountReturnsObjectIfAccFound(){
        //Setup
        AccountRepository accountRepository= new AccountRepository();
        Account newAccount = new Account("necessityAccount", 100);


        //Test
        accountRepository.save(newAccount);
        Account tempAcc = accountRepository.findOne(newAccount.getId());

        //Validate
        assertThat(tempAcc.getId()).isEqualTo(newAccount.getId());
    }

    @Test
    public void findOneAccountReturnsNullIfAccNotFound(){
        //Setup
        AccountRepository accountRepository= new AccountRepository();


        //Test
        Account tempAcc = accountRepository.findOne(1);

        //Validate
        assertThat(tempAcc).isEqualTo(null);
    }

    @Test
    public void findAllReturnsAllObjectsInRepo(){
        //Setup
        AccountRepository accountRepository = new AccountRepository();
        Account Acc1 = new Account("necessityAccount", 100);
        Account Acc2 = new Account("necessityAccount", 200);
        Account Acc3 = new Account("necessityAccount", 300);

        //Test
        accountRepository.save(Acc1);
        accountRepository.save(Acc2);
        accountRepository.save(Acc3);
        List<Account> accs = accountRepository.findAll();

        //Validate
        assertThat(accs.size()).isEqualTo(3);
    }
}
