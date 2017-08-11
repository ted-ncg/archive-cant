package com.visa.ncg.canteen.data;

import com.visa.ncg.canteen.domain.Account;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by nedsouza on 8/8/2017.
 */

@Service
public class InMemoryAccountRepository {

    private HashMap<Long, Account> accountRepository;

    public InMemoryAccountRepository() {
        accountRepository = new HashMap<>();
    }


    public Account save(Account account)
    {
        if (account.getId() ==0L )
        {
            account.setId(accountRepository.size()+1);
        }
        accountRepository.put(account.getId(), account);
        return account;
    }


    public Account find(long ID)
    {
        return accountRepository.get(ID);
    }

    public List<Account> findAll() {

        return (new ArrayList<Account>(accountRepository.values()));
    }

}
