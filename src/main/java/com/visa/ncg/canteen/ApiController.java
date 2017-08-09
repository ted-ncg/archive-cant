package com.visa.ncg.canteen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {
    AccountRepository accountRepository;

    public ApiController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping ("/api/accounts")
    public List<Account> findAll(){
        return accountRepository.findAll();
    }

    @GetMapping ("/api/account/{id}")
    public Account findByID(@PathVariable long id) {
        return accountRepository.findOne(id);
    }
}
