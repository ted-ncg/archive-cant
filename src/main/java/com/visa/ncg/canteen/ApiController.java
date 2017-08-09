package com.visa.ncg.canteen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by djose on 8/9/17.
 */

@RestController
public class ApiController {


    @GetMapping("/api/accounts")
    public List<Account> returnAllAccounts()
    {
        AccountRepository repository =new AccountRepository();
        List<Account> accountList = repository.findAll();
        return accountList;

    }
}
