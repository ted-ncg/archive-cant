package com.visa.ncg.canteen;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Created by nedsouza on 8/9/2017.
 */

@RestController
public class ApiController {

    private final Repository repository;


    public ApiController(Repository repository) {
        this.repository = repository;
    }

    @GetMapping("/api/accounts")
    public List<Account> returnAcccount(){
        return repository.findAll();
    }

    @GetMapping("/api/accounts/{id}")
    public Account findById(@PathVariable("id") Long id){
        return repository.find(id);
    }
}
