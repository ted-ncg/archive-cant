package com.visa.ncg.canteen;

public class AccountRepository {

    public  Account save(Account account)
    {
        account.setId(1);
        return account;
    }
}
