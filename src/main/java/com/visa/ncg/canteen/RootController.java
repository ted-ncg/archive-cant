package com.visa.ncg.canteen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class RootController {
    private AccountRepository accountRepository;

    @Autowired
    public RootController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/account/{id}")
    public String accountView(Model model, @PathVariable("id") Long id) {
        model.addAttribute("account", accountRepository.findOne(id));
        return "account-view";
    }

    @GetMapping("/accounts")
    public String allAccountsView(Model model) {
        model.addAttribute("accounts",accountRepository.findAll());
        return "accounts-view";
    }
}
