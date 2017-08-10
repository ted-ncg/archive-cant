package com.visa.ncg.canteen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by djose on 8/9/17.
 */

@Controller
public class RootController {

    private final AccountRepository repository;

    @Autowired
    public RootController(AccountRepository repository)
    {
        this.repository = repository;
    }


    @GetMapping("/account/{id}")
    public String root(Model model, @PathVariable("id") Long id )
    {
        Account account = repository.findOne(id);

        model.addAttribute("account", account);
        return "account-view";
    }

    @GetMapping("/accounts")
    public String viewAllAccounts(Model model)
    {

        List<Account> accountList = repository.findAll();

        model.addAttribute("accountList",accountList);
        return "accounts";
    }
}
