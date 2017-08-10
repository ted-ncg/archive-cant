package com.visa.ncg.canteen;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class WebController {

    private AccountRepository accountRepository;
    public WebController(AccountRepository repository)
    {
        this.accountRepository = repository;
    }

    @GetMapping("/")
    public  String root(){
        return  "index";
    }

    @GetMapping("/account/{id}")
    public  String account(Model model, @PathVariable("id") String id){
        model.addAttribute("account", accountRepository.findOne(Long.parseLong(id)));
        return "account-view";
    }

    @GetMapping("/account")
    public  String account(Model model){
        model.addAttribute("account", accountRepository.findOne(1));
        return "account-view";
    }
}
