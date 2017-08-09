package com.visa.ncg.canteen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CanteenApplication {

    public static void main(String[] args) {
        SpringApplication.run(CanteenApplication.class, args);
    }

    @Bean
    public AccountRepository createAccountRepository() {
        AccountRepository repository = new AccountRepository();
        repository.save(new Account("Bank", 10));
        repository.save(new Account("Bank", 20));
        repository.save(new Account("Bank", 30));
        repository.save(new Account("Bank", 40));
        return repository;
    }
}
