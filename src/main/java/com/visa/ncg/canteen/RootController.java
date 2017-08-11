package com.visa.ncg.canteen;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RootController {


    private CurrencyService currencyService;
    private AccountService accountService;
    private AccountRepository accountRepository;

    public RootController(AccountRepository accountRepository, CurrencyService currencyService, AccountService accountService){

        this.accountRepository = accountRepository;
        this.accountService = accountService;
        this.currencyService = currencyService;
    }


    @GetMapping("/accounts")
    public String viewAllAccounts(Model model){

        model.addAttribute("accounts", accountRepository.findAll());
        return "accounts";
    }

    @GetMapping("/account/{id}")
    public String root(Model model, @PathVariable("id") String id){
        Account account = accountRepository.findOne(Long.parseLong(id));
        model.addAttribute(account);

        model.addAttribute("gbp", currencyService.convertToGbp(account.getBalance()));
        return "account-view";
    }

    @GetMapping("/withdraw/{id}")
    public String withdrawGet(Model model, @PathVariable("id") long id){
        Account account = accountRepository.findOne(id);
        model.addAttribute(account);

        WithdrawForm withdrawForm = new WithdrawForm();
        withdrawForm.setAccountId(account.getId());
        model.addAttribute(withdrawForm);

        return "withdraw";
    }

    @PostMapping("/withdraw")
    public String withdrawPost(@ModelAttribute WithdrawForm withdrawForm){
        Account account = accountRepository.findOne(withdrawForm.getAccountId());
        accountService.withdraw(account, withdrawForm.getAmount());
        return "redirect:/account/" + withdrawForm.getAccountId();
    }
}
