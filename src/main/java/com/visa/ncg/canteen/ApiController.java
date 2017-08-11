package com.visa.ncg.canteen;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    private AccountRepository accountRepository;

    public ApiController(AccountRepository accountRepository){

        this.accountRepository = accountRepository;
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
