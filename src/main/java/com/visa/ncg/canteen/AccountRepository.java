package com.visa.ncg.canteen;

/**
 * Created by djose on 8/8/17.
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;


public class AccountRepository {

    HashMap<Long,Account> accountRepository = new HashMap();

    Account findOne(long id)
    {
        return accountRepository.get(id);

    }

    public void save(Account account)
    {

        long new_id = accountRepository.size()*10000 + 1;

        if (account.getId() == 0){
            account.setId(new_id);
            accountRepository.put(new_id,account);
        }
        else
            accountRepository.put(account.getId(), account);




    }

    public ArrayList<Account> findAll()
    {
        ArrayList<Account> accountList = new ArrayList<>();

        for (Account acnt : accountRepository.values()) {
            accountList.add(acnt);
        }

        return accountList;
    }

}

