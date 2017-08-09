package com.visa.ncg.canteen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    @GetMapping("/api/test")
    public String returnAllAccounts(){
        return "all accounts";
    }

    @GetMapping("/api/accounts")
    public List<Account> getAllAccounts(){
        AccountRepository accRepo = new AccountRepository(5);
        return accRepo.findAll();
    }
}
