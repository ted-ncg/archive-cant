package com.visa.ncg.canteen;

import org.springframework.stereotype.Service;

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
