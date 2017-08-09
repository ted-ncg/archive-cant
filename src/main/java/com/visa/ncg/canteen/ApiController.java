package com.visa.ncg.canteen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    private AccountRepository accountRepository;

    public ApiController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/api/accounts")
    public List<Account> getAllAccounts() {
        return this.accountRepository.findAll();
    }

    @GetMapping("/api/account/{accountId}")
    public Account getOneAccount(@PathVariable("accountId") Long accountId) {
        return this.accountRepository.findOne(accountId);
    }
}
