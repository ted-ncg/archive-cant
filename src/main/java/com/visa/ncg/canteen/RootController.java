package com.visa.ncg.canteen;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class RootController {

    AccountRepository repo;

    public RootController(AccountRepository repo) {
        this.repo = repo;
    }

    @ResponseStatus(value= HttpStatus.NOT_FOUND, reason="No such Account")  // 404
    public class OrderNotFoundException extends RuntimeException {
        // ...
        OrderNotFoundException(long id)
        {

        }
    }
    @GetMapping("/account/{id}")
    public String account(Model model, @PathVariable long id) {
        Account account = repo.findOne(id);
        if (account == null) throw new OrderNotFoundException(id);
        model.addAttribute("account", account);
        return "account-view";
    }

    @GetMapping ("/accounts")
    public String viewAllAccounts(Model model) {
        model.addAttribute("accounts", repo.findAll());
        return "accounts";
    }



}
