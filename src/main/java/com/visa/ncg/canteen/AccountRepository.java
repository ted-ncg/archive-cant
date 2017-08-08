package com.visa.ncg.canteen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

public class AccountRepository {

    HashMap<Long, Account> accountMap;
    long currentIndex;

    public AccountRepository(){
        accountMap = new HashMap<Long, Account>();
        currentIndex = 1;
    }

    public void save(Account account){

        if(account.ID == null){
            account.ID = currentIndex;
            currentIndex++;
            accountMap.put(account.ID, account);
        }

    }

    public Account findOne(long id) {
        if (accountMap.containsKey(id)) {
            return accountMap.get(id);
        }
        else {
            return null;
        }
    }

    public List<Account> findAll(){
        return new ArrayList<Account>(accountMap.values());
    }

}
