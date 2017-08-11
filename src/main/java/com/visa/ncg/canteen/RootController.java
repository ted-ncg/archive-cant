package com.visa.ncg.canteen;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class RootController {
    private AccountRepository accountRepository;
    private AccountService accountService;
    private CurrencyService currencyService;

    @Autowired
    public RootController(AccountRepository accountRepository, AccountService accountService, CurrencyService currencyService) {
        this.accountRepository = accountRepository;
        this.accountService = accountService;
        this.currencyService = currencyService;
    }

    @GetMapping("/account/{id}")
    public String accountView(Model model, @PathVariable("id") Long id) {
        Account account = accountRepository.findOne(id);
        model.addAttribute("account", account);
        model.addAttribute("converted", currencyService.convertToGbp(account.getBalance()));
        return "account-view";
    }

    @GetMapping("/accounts")
    public String allAccountsView(Model model) {
        model.addAttribute("accounts",accountRepository.findAll());
        return "accounts-view";
    }

    @GetMapping("/withdraw/{id}")
    public String withdrawAmount(Model model, @PathVariable("id") long id, WithdrawForm withdrawForm) {
        model.addAttribute("account", accountRepository.findOne(id));
        withdrawForm.setAccountId(id);
        return "withdraw";
    }

    @PostMapping("/withdraw")
    public String withdrawPost(@ModelAttribute WithdrawForm form) {
        Account account = accountRepository.findOne(form.getAccountId());
        accountService.withdraw(account,form.getAmount());
        accountRepository.save(account);
        return "redirect:/account/" + form.getAccountId();
    }
}
