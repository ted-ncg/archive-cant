package com.visa.ncg.canteen;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
public class WebController {

    private AccountRepository accountRepository;
    private CurrencyService currencyService;
    public WebController(AccountRepository repository, CurrencyService service) {
        this.accountRepository = repository;
        this.currencyService = service;
    }

    @GetMapping("/account/{id}")
    public  String account(Model model, @PathVariable("id") Long id){
        model.addAttribute("account", accountRepository.findOne(id));
        Integer gbp = currencyService.convertToGbp(accountRepository.findOne(id).getBalance());
        model.addAttribute("gbp", gbp);
        return "account-view";
    }

    @GetMapping("/accounts")
    public  String allAccounts(Model model){
        model.addAttribute("accounts", accountRepository.findAll());
        return "accounts";
    }

    @GetMapping("/withdraw/{id}")
    public String withdrawGet(Model model,
                              @PathVariable("id") long id) {
        // put the Account into the model
        model.addAttribute("account",accountRepository.findOne(id));

        // create a new WithdrawForm and set its accountId
        WithdrawForm withdrawFormObject = new WithdrawForm();
        withdrawFormObject.setAccountId(id);

        model.addAttribute("withdrawForm", withdrawFormObject);
        return "withdraw";
    }

    @PostMapping("/withdraw")
    public String withdrawPost(@ModelAttribute WithdrawForm form) {
        // get the account ID from the form
        long accountID = form.getAccountId();

        AccountService service = new AccountService();
        // execute the withdraw on that account via the service

        service.withdraw(accountRepository.findOne(accountID), form.getAmount());

        return "redirect:/account/" + form.getAccountId();
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public String handleAppException(IllegalArgumentException ex) {
        return ex.getMessage();
    }
}