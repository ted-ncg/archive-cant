package com.visa.ncg.canteen;

import org.junit.Test;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by nedsouza on 8/8/2017.
 */
public class AccountRepositoryActions {

    @Test
    public void saveAccountIDIfNotNull() throws Exception {

        Account newParent = new Account("Necessities", 10);
        Repository repository = new Repository();

        assertThat(repository.save(newParent))
                .isNotEqualTo(0L);
    }

    @Test
    public void findAccountIDIfNotExists() throws Exception {
        Account newParent = new Account("Necessities", 10);
        Repository repository = new Repository();

        assertThat(repository.find(newParent.ID))
                .isEqualTo(null);
    }

    @Test
    public void findAccountIDIfExists() throws Exception {
        Account newParent = new Account("Necessities", 10);
        Repository repository = new Repository();

        long newID = repository.save(newParent);

        assertThat(repository.find(newID))
                .isNotEqualTo(null);
    }

    @Test
    public void findAll() throws Exception {
        Repository repository = new Repository();

        List<Account> accountList = repository.findAll();
        assertThat(accountList).isEmpty();
    }
}