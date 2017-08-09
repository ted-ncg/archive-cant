package com.visa.ncg.canteen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by djose on 8/9/17.
 */

@RestController
public class ApiController {

    private final AccountRepository repository;

    public ApiController(AccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/accounts")
    public List<Account> returnAllAccounts()
    {
        List<Account> accountList = repository.findAll();
        return accountList;

    }


    @GetMapping("/api/account/{id}")
    public Account findById(@PathVariable("id") String id)
    {
        String error = "Error!!!";
        Account account = null;
        Long longID = null;

        try
        {
            longID = Long.parseLong(id);
        }
        catch (NumberFormatException exp)
        {
            // ignore the error

        }

        if(longID != null)
        {
           account = repository.findOne(longID);

        }

        return account;
    }

}
