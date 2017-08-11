package com.visa.ncg.canteen;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class FakeDataLoader implements ApplicationRunner {

    private AccountRepository accountRepository;

    public FakeDataLoader(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception{
        Account account = accountRepository.save(new Account("Bank", 100));
        account = accountRepository.save(new Account("Neccessities", 60));
        account = accountRepository.save(new Account("Luxuries", 30));
    }
}
