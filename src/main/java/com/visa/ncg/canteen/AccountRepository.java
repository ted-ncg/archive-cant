package com.visa.ncg.canteen;

/**
 * Created by djose on 8/8/17.
 *
 */

import java.util.ArrayList;
import java.util.HashMap;

public class AccountRepository {

    private  HashMap<Long,Account> accountRepository;



    public AccountRepository() {

        accountRepository = new HashMap<>();
        accountRepository.put(1234L, new Account("Necessities",20,1234));
        accountRepository.put(1235L, new Account("Savings",30,1235));
        accountRepository.put(1236L, new Account("Checking",40,1236));

    }


    Account findOne(long id)
    {
        return accountRepository.get(id);
    }

    public Account save(Account account)
    {

        long new_id = accountRepository.size()*10000 + 1;

        if (account.getId() == 0){
            account.setId(new_id);
            accountRepository.put(new_id,account);
        }
        else
            accountRepository.put(account.getId(), account);

        return account;

    }

    public ArrayList<Account> findAll()
    {
        return new ArrayList<>(accountRepository.values());
    }

}

