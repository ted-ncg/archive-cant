package com.visa.ncg.canteen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ApiController {

    @GetMapping("/api/accounts")
    public List<Account> getAllAccounts() {
        return new AccountRepository().findAll();
    }
}
