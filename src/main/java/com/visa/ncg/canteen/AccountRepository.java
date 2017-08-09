package com.visa.ncg.canteen;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    private HashMap<Long,Account> accountRepository = new HashMap<>();
    private Long nextUniqueId = new Long(0);

    public AccountRepository() {
        Account account1 = new Account("Account 1", 0);
        Account account2 = new Account("Account 2", 0);

        this.save(account1);
        this.save(account2);
    }

    public Account save(Account account) {

        if(account.getId() == null) {
            nextUniqueId = new Long(nextUniqueId.longValue()+1);
            account.setAccountId(nextUniqueId);
            accountRepository.put(this.nextUniqueId,account);
        }

        return account;
    }

    public Account findOne(Long accountId) {
        return accountRepository.get(accountId);
    }

    public List<Account> findAll() {
        return new ArrayList<>(accountRepository.values());
    }
}
