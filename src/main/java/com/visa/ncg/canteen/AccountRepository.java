package com.visa.ncg.canteen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AccountRepository {

    Map<Long,Account> accRepo = new HashMap<>();
    private long id = 0;

    public AccountRepository(){

    }
    public AccountRepository(int numberOfAccounts)
    {
        for (int i =0; i<numberOfAccounts; i++)
        {
            Account a = new Account("bank"+i, i*100);
            save(a);
        }
    }
    public Account save (Account newAcc)
    {
        if(newAcc.getId()!=0)return newAcc;

        newAcc.setId(++id);
        accRepo.put(id,newAcc);
        return newAcc;
    }

    public Account findOne(long id) {
        return accRepo.get(id);
    }

    public List<Account> findAll() {
        return new ArrayList<>(accRepo.values());
    }
}
