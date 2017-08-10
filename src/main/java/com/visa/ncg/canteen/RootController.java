package com.visa.ncg.canteen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {
    private AccountRepository accountRepository;

    @Autowired
    public RootController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/")
    public String root() {
        return "index";
    }

    @GetMapping("/account")
    public String accountView(Model model) {
        model.addAttribute("account", accountRepository.findOne(1L));
        return "account-view";
    }
}
