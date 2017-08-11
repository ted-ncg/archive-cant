package com.visa.ncg.canteen;

import com.visa.ncg.canteen.data.AccountRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApiController {

    private AccountRepository inMemoryAccountRepository;

    public ApiController(AccountRepository inMemoryAccountRepository){

        this.inMemoryAccountRepository = inMemoryAccountRepository;
    }

    @GetMapping("/api/accounts")
    public List<Account> getAllAccounts(){

        return (List<Account>) inMemoryAccountRepository.findAll();
    }

    @GetMapping("/api/accounts/{id}")
    public Account findById(@PathVariable("id") String id){

        return inMemoryAccountRepository.findOne(Long.parseLong(id));
    }


}
