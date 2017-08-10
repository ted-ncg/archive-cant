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
  public AccountRepository createRepository(){
    AccountRepository accountRepository = new AccountRepository();

    Account account1 = new Account("Bank", 100);
    Account account2 = new Account("Necessities", 250);

    accountRepository.save(account1);
    accountRepository.save(account2);

    return accountRepository;
  }

}
