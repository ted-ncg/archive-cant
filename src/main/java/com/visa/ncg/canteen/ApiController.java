package com.visa.ncg.canteen;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.JsonNodeFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * Created by djose on 8/9/17.
 */

@RestController
public class ApiController {

    private final AccountRepository repository;

    @Autowired
    public ApiController(AccountRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/accounts")
    public List<Account> returnAllAccounts()
    {
        List<Account> accountList = repository.findAll();
        return accountList;

    }


    @GetMapping("/api/account/{id}")
    public Account findById(@PathVariable("id") Long id)
    {
        Account account = null;


        if(id != null)
        {
           account = repository.findOne(id);

        }

        return account;
    }

    @RequestMapping("/api/accounts/{id}")
    public ResponseEntity<Account> handle(@PathVariable("id") String id) {

        Account account = null;
        Long longID = null;

        try
        {
            longID = Long.parseLong(id);
        }
        catch (NumberFormatException exp)
        {
            // ignore the exception throw from id


        }


        if(longID != null)
        {
            account = repository.findOne(longID);
            return ResponseEntity.ok(account);
        }

        return ResponseEntity.badRequest().build();



    }
}
