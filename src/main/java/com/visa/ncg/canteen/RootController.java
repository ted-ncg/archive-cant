package com.visa.ncg.canteen;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RootController {

    AccountRepository repo;

    public RootController(AccountRepository repo) {
        this.repo = repo;
    }

    @GetMapping("/account/{id}")
    public String account(Model model, @PathVariable long id) {
        Account account = repo.findOne(id);
        model.addAttribute("account", account);
        return "account-view";
    }

    @GetMapping ("/accounts")
    public String viewAllAccounts(Model model) {
        model.addAttribute("accounts", repo.findAll());
        return "accounts";
    }



}
