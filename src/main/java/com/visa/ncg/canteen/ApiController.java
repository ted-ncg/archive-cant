package com.visa.ncg.canteen;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * Created by nedsouza on 8/9/2017.
 */

@RestController
public class ApiController {

    @GetMapping("/api/accounts")
    public List<Account> returnAcccount(){

        Repository repository = new Repository();
        return repository.findAll();

    }

}
