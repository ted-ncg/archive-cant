package com.visa.ncg.canteen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController
{
    @GetMapping("/api/accounts")
    public List<Account> getAllAccounts()
    {
        AccountRepository repository = new AccountRepository();
        repository.save(new Account("Bank",10));
        repository.save(new Account("Bank",20));
        repository.save(new Account("Bank",30));
        repository.save(new Account("Bank",40));
        return  repository.findAll();
    }


}
