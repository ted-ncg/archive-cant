package com.visa.ncg.canteen;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CanteenApplication {

  public static void main(String[] args)
  {
    SpringApplication.run(CanteenApplication.class, args);
  }

  @Bean
  public AccountRepository createAccountRepository()
  {
    AccountRepository accountRepository = new AccountRepository();

      accountRepository.save(new Account("Savings",20));
      accountRepository.save(new Account("Checking",10));
      accountRepository.save(new Account("Necessities",30));

      return accountRepository;
  }

}
