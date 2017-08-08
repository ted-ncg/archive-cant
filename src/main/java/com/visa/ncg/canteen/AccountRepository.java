package com.visa.ncg.canteen;

import java.util.ArrayList;
import java.util.List;

public class AccountRepository {

    ArrayList<Account> listOfAccounts;

    public AccountRepository(){
        listOfAccounts = new ArrayList<>();
    }

    public  Account save(Account account)
    {

        listOfAccounts.add(account);

        //can save new Account
        if(account.id() == 0){
            account.setId(1);
        }
        return account;
    }

    public  Account findOne(long id)
    {
        return listOfAccounts.get(0);
    }

    public List<Account> findAll() {
        return listOfAccounts;
    }
}
