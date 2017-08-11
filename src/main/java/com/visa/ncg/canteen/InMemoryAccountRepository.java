package com.visa.ncg.canteen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class InMemoryAccountRepository {

    Map<Long,Account> accRepo = new HashMap<>();
    private long id = 0;

    public InMemoryAccountRepository(){

    }
    public InMemoryAccountRepository(int numberOfAccounts)
    {

        for (int i =1; i<=numberOfAccounts; i++)
        {
            Account a;
            if(i%3==0)
                a = new Account("bank", i*200);
            else
                a = new Account("necessities", i*10);
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
