package com.visa.ncg.canteen;

import javax.validation.constraints.Null;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountRepository {

    Map<Long, Account> accountRepository;
    int counter = 1;

    public AccountRepository() {
        accountRepository = new HashMap<>();
    }

    public Account save(Account account) {
        if (account.getId() == 0) {
            //Save as new account
            account.setId(counter++);
        }
        accountRepository.put(account.getId(), account);

        return account;
    }

    public Account findOne(long id) {
        return accountRepository.get(id);
    }

    public List<Account> findAll() {
        return new ArrayList<Account>(accountRepository.values());
    }
}
