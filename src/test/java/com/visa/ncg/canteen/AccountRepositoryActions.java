package com.visa.ncg.canteen;

import com.visa.ncg.canteen.domain.Account;
import com.visa.ncg.canteen.data.InMemoryAccountRepository;
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
        InMemoryAccountRepository accountRepository = new InMemoryAccountRepository();

        assertThat(accountRepository.save(newParent))
                .isNotEqualTo(0L);
    }

    @Test
    public void findAccountIDIfNotExists() throws Exception {
        Account newParent = new Account("Necessities", 10);
        InMemoryAccountRepository accountRepository = new InMemoryAccountRepository();

        assertThat(accountRepository.find(newParent.getId()))
                .isEqualTo(null);
    }

    @Test
    public void findAccountIDIfExists() throws Exception {
        Account newParent = new Account("Necessities", 10);
        InMemoryAccountRepository accountRepository = new InMemoryAccountRepository();

        accountRepository.save(newParent);

        assertThat(accountRepository.find(newParent.getId()))
                .isNotEqualTo(null);
    }

    @Test
    public void findAll() throws Exception {
        InMemoryAccountRepository accountRepository = new InMemoryAccountRepository();

        List<Account> accountList = accountRepository.findAll();
        assertThat(accountList).isNotEmpty();
    }

}