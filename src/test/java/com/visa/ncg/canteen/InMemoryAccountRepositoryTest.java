package com.visa.ncg.canteen;

import org.junit.Test;
import java.util.List;
import static org.assertj.core.api.Assertions.assertThat;

public class InMemoryAccountRepositoryTest {

    @Test
    public void saveAccountReturnsNewObjectWithID() {
        //Setup
        InMemoryAccountRepository inMemoryAccountRepository = new InMemoryAccountRepository();
        Account newAccount = new Account("NecessityAccount", 50);

        //Test
        inMemoryAccountRepository.save(newAccount);

        //Validate
        assertThat(newAccount.getId()).isNotEqualTo(0);
    }

    @Test
    public void saveAccountReturnsNewObjectWithIDIncremented(){
        //Setup
        InMemoryAccountRepository inMemoryAccountRepository = new InMemoryAccountRepository();
        Account newAccount = new Account("necessityAccount", 60);
        Account anotherAcc = new Account("NecessityAccount", 50);

        //Test
        inMemoryAccountRepository.save(newAccount);
        inMemoryAccountRepository.save(anotherAcc);

        //Validate
        assertThat(newAccount.getId()).isNotEqualTo(anotherAcc.getId());
    }

    @Test
    public void saveAccountReturnsSameObjectIfIDProvided(){
        //Setup
        InMemoryAccountRepository inMemoryAccountRepository = new InMemoryAccountRepository();
        Account newAccount = new Account("necessityAccount", 80);

        //Test
        inMemoryAccountRepository.save(newAccount);
        long prevId = newAccount.getId();
        inMemoryAccountRepository.save(newAccount);

        //Validate
        assertThat(newAccount.getId()).isEqualTo(prevId);
    }

    @Test
    public void findOneAccountReturnsObjectIfAccFound(){
        //Setup
        InMemoryAccountRepository inMemoryAccountRepository = new InMemoryAccountRepository();
        Account newAccount = new Account("necessityAccount", 100);


        //Test
        inMemoryAccountRepository.save(newAccount);
        Account tempAcc = inMemoryAccountRepository.findOne(newAccount.getId());

        //Validate
        assertThat(tempAcc.getId()).isEqualTo(newAccount.getId());
    }

    @Test
    public void findOneAccountReturnsNullIfAccNotFound(){
        //Setup
        InMemoryAccountRepository inMemoryAccountRepository = new InMemoryAccountRepository();


        //Test
        Account tempAcc = inMemoryAccountRepository.findOne(1);

        //Validate
        assertThat(tempAcc).isEqualTo(null);
    }

    @Test
    public void findAllReturnsAllObjectsInRepo(){
        //Setup
        InMemoryAccountRepository inMemoryAccountRepository = new InMemoryAccountRepository();
        Account Acc1 = new Account("necessityAccount", 100);
        Account Acc2 = new Account("necessityAccount", 200);
        Account Acc3 = new Account("necessityAccount", 300);

        //Test
        inMemoryAccountRepository.save(Acc1);
        inMemoryAccountRepository.save(Acc2);
        inMemoryAccountRepository.save(Acc3);
        List<Account> accs = inMemoryAccountRepository.findAll();

        //Validate
        assertThat(accs.size()).isEqualTo(3);
    }
}
