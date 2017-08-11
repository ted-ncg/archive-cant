package com.visa.ncg.canteen;

import org.springframework.stereotype.Service;

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
        Account account1 = new Account("Account 1", 100);
        Account account2 = new Account("Account 2", 100);

        this.save(account1);
        this.save(account2);
    }

    public void save(Account account){

        if(account.getId() == 0){
            account.setId(currentIndex);
            currentIndex++;
            accountMap.put(account.getId(), account);
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
