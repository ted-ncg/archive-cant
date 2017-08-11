package com.visa.ncg.canteen;

import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

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
    public String accountView(Model model, @PathVariable("id") long id, CurrencyService currencyService){
        Account account = accountRepository.find(id);
//        if (account == null) {
//            return "404";
//        }
        model.addAttribute("account", account);

        Currency currency = currencyService.convertToGBP(account.getBalance());
        model.addAttribute("currency", currency);

        return "account-view";
    }

    @GetMapping("/accounts")
    public String viewAllAccounts(Model model) {
        List<Account> allAccounts = accountRepository.findAll();
        model.addAttribute("allAccounts", allAccounts);
        return "accounts";
    }

    @GetMapping("/withdraw/{id}")
    public String withdrawGet(Model model, @PathVariable("id") long id) {

        Account account = accountRepository.find(id);

        WithdrawForm form = new WithdrawForm();
        form.setAccountId(id);

        model.addAttribute("account", account);
        model.addAttribute("withdrawForm", form);

        return "withdraw";
    }

    @PostMapping("/withdraw")
    public String withdrawPost(@ModelAttribute WithdrawForm form) {
        // get the account id from the form
        Account account = accountRepository.find(form.getAccountId());

        // execute the withdraw on that account via the service
        AccountService accountService = new AccountService(accountRepository);
        accountService.withdraw(account, form.getAmount());

        return "redirect:/account/" + form.getAccountId();
    }



}
