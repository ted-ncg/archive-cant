package com.visa.ncg.canteen;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    @GetMapping("/accounts")
    public String viewAllAccounts(Model model){
        AccountRepository repo = new AccountRepository(5);
        model.addAttribute("accounts", repo.findAll());
        return "accounts";
    }

    @GetMapping("/account")
    public String root(Model model){
        Account account = new Account("bank", 200);
        model.addAttribute("account", account);
        return "account-view";
    }

}
