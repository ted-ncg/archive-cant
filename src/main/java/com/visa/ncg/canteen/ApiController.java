package com.visa.ncg.canteen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

/**
 * Created by djose on 8/9/17.
 */

@Controller
public class ApiController {

    private final AccountRepository repository;

    @Autowired
    public ApiController(AccountRepository repository)
    {
        this.repository = repository;
    }

    AccountService service = new AccountService();


    @GetMapping("/account/{id}")
    public String root(Model model, @PathVariable("id") Long id )
    {
        Account account = repository.findOne(id);

        model.addAttribute("account", account);
        return "account-view";
    }

    @GetMapping("/accounts")
    public String viewAllAccounts(Model model)
    {

        List<Account> accountList = repository.findAll();

        model.addAttribute("accountList",accountList);
        return "accounts";
    }


    @GetMapping("/withdraw/{id}")
    public String withdrawGet(Model model, @PathVariable("id") long id) {
        // put the Account into the model
        // create a new WithdrawForm and set its accountId

        Account account = repository.findOne(id);
        model.addAttribute("account", account);


        WithdrawForm form = new WithdrawForm();
        form.setAccountId(id);
        model.addAttribute("withdrawForm",form);

        return "withdraw";
    }


    @PostMapping("/withdraw")
    public String withdrawPost(@ModelAttribute WithdrawForm form) {
        // get the account ID from the form
        // execute the withdraw on that account via the service

        Account account = repository.findOne(form.getAccountId());
        service.withdraw(account, form.getAmount());

        return "redirect:/account/" + form.getAccountId();
    }



}
