package com.visa.ncg.canteen;

import com.visa.ncg.canteen.data.AccountRepository;
import com.visa.ncg.canteen.domain.Account;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * Created by nedsouza on 8/11/2017.
 */

@Component
public class FakeDataLoader implements ApplicationRunner {

    private AccountRepository accountRepository;

    public FakeDataLoader(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {

        Account account = accountRepository.save(new Account("Bank", 250));
        System.out.println(account);
        account = accountRepository.save(new Account("Necessities", 150));
        System.out.println(account);
        account = accountRepository.save(new Account("Luxuries", 115));
    }
}
