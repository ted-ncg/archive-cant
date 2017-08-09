package com.visa.ncg.canteen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class CanteenApplication {

  public static void main(String[] args) {
      SpringApplication.run(CanteenApplication.class, args);
  }

  @Bean
  public AccountRepository createAccountRepository() {
    AccountRepository accountRepository = new AccountRepository();
    for(int i = 1; i <= 200; i++) {
        accountRepository.save(new Account("Account" + i,i));
    }
    return accountRepository;
  }
}
