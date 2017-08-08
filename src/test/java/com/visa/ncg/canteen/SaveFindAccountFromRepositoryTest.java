package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class SaveFindAccountFromRepositoryTest {

    @Test
    public void saveNewAccoutWithoutIDGeneratesID() throws Exception
    {
        AccountRepository repository = new  AccountRepository();
        Account newAccount = new Account("Canteen", 0);

        newAccount = repository.save(newAccount);

        assertThat(newAccount.id()).isNotEqualTo(0);
    }

}
