package com.visa.ncg.canteen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by nedsouza on 8/8/2017.
 */
public class Repository {

    private HashMap<Long, Account> accountRepository;

    public Repository() {
        accountRepository = new HashMap<>();

        Account account1 = new Account("Bank", 100);
        Account account2 = new Account("Necessities", 250);

        save(account1);
        save(account2);
    }

    public long save(Account account)
    {
        if (account.ID ==0L )
        {
            account.ID = accountRepository.size()+1;
            accountRepository.put(account.ID, account);
        }
        return account.ID;
    }


    public Account find(long ID)
    {
        return accountRepository.get(ID);
    }

    public List<Account> findAll() {
        return (new ArrayList<Account>(accountRepository.values()));
    }
}
