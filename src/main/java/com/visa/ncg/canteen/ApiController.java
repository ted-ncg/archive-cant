package com.visa.ncg.canteen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiController {
    AccountRepository accountRepository = new AccountRepository();

    @GetMapping ("/api/accounts")
    public List<Account> findAll(){
        return new ArrayList<>(accountRepository.accountMap.values());
    }

}
