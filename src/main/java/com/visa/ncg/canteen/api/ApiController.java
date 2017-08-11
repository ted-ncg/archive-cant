package com.visa.ncg.canteen.api;
import com.visa.ncg.canteen.domain.Account;
import com.visa.ncg.canteen.data.InMemoryAccountRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Created by nedsouza on 8/9/2017.
 */

@RestController
public class ApiController {

    private final InMemoryAccountRepository accountRepository;


    public ApiController(InMemoryAccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @GetMapping("/api/accounts")
    public List<Account> returnAcccount(){
        return accountRepository.findAll();
    }

    @GetMapping("/api/accounts/{id}")
    public Account findById(@PathVariable("id") Long id){
        System.out.println("Account findByID: " + accountRepository.find(id));
        return accountRepository.find(id);
    }
}
