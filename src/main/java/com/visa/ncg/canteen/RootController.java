package com.visa.ncg.canteen;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RootController {

    Account account;

    public RootController(Account account) {
        this.account = account;
    }

    @GetMapping("/")
    public String root() {
        return "index";
    }


    @GetMapping("/account")
    public String account(Model model) {
        model.addAttribute("account", account);
        return "account-view";
    }

}
