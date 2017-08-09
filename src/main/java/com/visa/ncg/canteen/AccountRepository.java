package com.visa.ncg.canteen;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;

public class AccountRepository {
    private HashMap<Long,Account> accountRepository = new HashMap<>();
    private Long nextUniqueId = 0L;

    public Account save(Account account) {

        if(account.getId() == null) {
            nextUniqueId++;
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
