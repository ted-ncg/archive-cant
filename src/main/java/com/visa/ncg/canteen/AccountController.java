package com.visa.ncg.canteen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController
{
    private AccountRepository accountRepository;
    public AccountController(AccountRepository repository)
    {
        this.accountRepository = repository;
    }

    @GetMapping("/api/accounts")
    public List<Account> getAllAccounts()
    {
        return  this.accountRepository.findAll();
    }

    @GetMapping("/api/account/{id}")
    public Account getAccountById(@PathVariable("id") String id)
    {
        return this.accountRepository.findOne(Long.parseLong(id));
    }
}
