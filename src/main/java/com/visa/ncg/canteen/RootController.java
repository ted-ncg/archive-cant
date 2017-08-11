package com.visa.ncg.canteen;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/withdraw/{id}")
    public String withdrawGet(Model model,
                              @PathVariable("id") long id) {
        // put the Account into the model
        // create a new WithdrawForm and set its accountId
        WithdrawForm withdrawForm = new WithdrawForm();
        withdrawForm.setAccountID(id);
        Account account = repo.findOne(id);
        model.addAttribute("account", account);
        model.addAttribute("withdrawForm", withdrawForm);
        return "withdraw";
    }

    @PostMapping("/withdraw")
    public String withdrawPost(@ModelAttribute WithdrawForm form) {
        // get the account ID from the form
        // execute the withdraw on that account via the service
        new AccountService().withdraw(
                repo.findOne(form.getAccountID()), form.getAmount());
        return "redirect:/account/" + form.getAccountID();
    }



}
