package com.visa.ncg.canteen;

import javax.validation.constraints.Null;
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
            account.setId(listOfAccounts.size());
        }
        return account;
    }

    public  Account findOne(long id)
    {
        return listOfAccounts.stream().filter( account ->
                account.id() == id).findFirst().orElse(null);
    }

    public List<Account> findAll() {
        return listOfAccounts;
    }
}
