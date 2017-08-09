package com.visa.ncg.canteen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    private AccountRepository accountRepository;

    public ApiController(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @GetMapping("/api/test")
    public String returnAllAccounts(){
        return "all accounts";
    }

    @GetMapping("/api/accounts")
    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    @GetMapping("/api/accounts/{id}")
    public Account findById(@PathVariable("id") String id){
        return accountRepository.findOne(Long.parseLong(id));
    }
}
