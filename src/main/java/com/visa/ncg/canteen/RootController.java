package com.visa.ncg.canteen;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by nedsouza on 8/9/2017.
 */
@Controller
public class RootController {
    @GetMapping("/")
    public String root(){

        return "index";
    }

    @GetMapping("/account")
    public String root(Model model){
        Account account = new Account("bank", 2);
        model.addAttribute("account", account);
        return "account-view";
    }
}
