package com.visa.ncg.canteen.web;

import com.visa.ncg.canteen.data.AccountRepository;
import com.visa.ncg.canteen.domain.AccountService;
import com.visa.ncg.canteen.domain.Account;
import com.visa.ncg.canteen.domain.ConversionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * Created by nedsouza on 8/9/2017.
 */
@Controller
public class RootController {
    AccountRepository accountRepository;
    AccountService accountService;

    public RootController(AccountRepository accountRepository, AccountService accountService) {
        this.accountRepository = accountRepository;
        this.accountService = accountService;
        accountService.setAccountRepository(accountRepository);
    }

    @GetMapping("/account/{id}")
    public String accountView(Model model, @PathVariable("id") long id, ConversionService conversionService){
        Account account = accountRepository.findOne(id);
//        if (account == null) {
//            return "404";
//        }
        model.addAttribute("account", account);

        System.err.println("account:" + account);

         int converted = conversionService.convertToGBP(account.getBalance());

        ConversionResponseWebModel conversionResponseWebModel = new ConversionResponseWebModel();
        conversionResponseWebModel.setConverted(converted);
        conversionResponseWebModel.setFrom("USD");
        conversionResponseWebModel.setTo("GBD");

        model.addAttribute("conversionResponseWebModel", conversionResponseWebModel);

        return "account-view";
    }

    @GetMapping("/accounts")
    public String viewAllAccounts(Model model) {

        List<Account> allAccounts = new ArrayList<Account>((Collection<? extends Account>) accountRepository.findAll());
        model.addAttribute("allAccounts", allAccounts);
        return "accounts";
    }

    @GetMapping("/withdraw/{id}")
    public String withdrawGet(Model model, @PathVariable("id") long id) {

        Account account = accountRepository.findOne(id);

        WithdrawForm form = new WithdrawForm();
        form.setAccountId(id);

        model.addAttribute("account", account);
        model.addAttribute("withdrawForm", form);

        return "withdraw";
    }

    @PostMapping("/withdraw")
    public String withdrawPost(@ModelAttribute WithdrawForm form) {
        // get the account id from the form
        Account account = accountRepository.findOne(form.getAccountId());

        // execute the withdraw on that account via the service;
        accountService.withdraw(account, form.getConverted());

        return "redirect:/account/" + form.getAccountId();
    }



}
