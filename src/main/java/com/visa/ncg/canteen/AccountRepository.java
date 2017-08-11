package com.visa.ncg.canteen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by nedsouza on 8/8/2017.
 */

public class AccountRepository {

    private HashMap<Long, Account> accountRepository;

    public AccountRepository() {
        accountRepository = new HashMap<>();
    }


    public Account save(Account account)
    {
        if (account.id ==0L )
        {
            account.id = accountRepository.size()+1;
        }
        accountRepository.put(account.id, account);
        return account;
    }


    public Account find(long ID)
    {
        return accountRepository.get(ID);
    }

    public List<Account> findAll() {

        return (new ArrayList<Account>(accountRepository.values()));
    }

}
