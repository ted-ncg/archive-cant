package com.visa.ncg.canteen.data;

import com.visa.ncg.canteen.domain.Account;
import com.visa.ncg.canteen.domain.AccountRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class FakeDataLoader  implements ApplicationRunner {

    private AccountRepository accountRepository;

    public FakeDataLoader(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        Account account = accountRepository.save(new Account("Bank", 100));
        account = accountRepository.save(new Account("Necessities", 20));
        accountRepository.save(new Account("Luxuries", 15));

    }
}
