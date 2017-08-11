package com.visa.ncg.canteen;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class FakeDataLoader implements ApplicationRunner {
    private AccountRepository accountRepository;

    public FakeDataLoader(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        String[] accounts = {"CHECKING", "SAVINGS", "MONEY_MARKET", "CD", "NECESSITIES", "LUXURIES"};
        Random rand = new Random();
        for (int i = 1; i <= 200; i++) {
            accountRepository.save(new Account(accounts[rand.nextInt(accounts.length)], Math.abs(rand.nextInt(1000000)+1)));
        }
    }
}
