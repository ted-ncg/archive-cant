package com.visa.ncg.canteen;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

/**
 * Created by nedsouza on 8/9/2017.
 */
@Controller
public class RootController {
    AccountRepository accountRepository;

    public RootController(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/account/{id}")
    public String accountView(Model model, @PathVariable("id") long id){
        Account account = accountRepository.find(id);
//        if (account == null) {
//            return "404";
//        }
        model.addAttribute("account", account);
        return "account-view";
    }

    @GetMapping("/accounts")
    public String viewAllAccounts(Model model) {
        List<Account> allAccounts = accountRepository.findAll();
        model.addAttribute("allAccounts", allAccounts);
        return "accounts";
    }


}
