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
  public Repository createRepository(){
    Repository repository = new Repository();

    Account account1 = new Account("Bank", 100);
    Account account2 = new Account("Necessities", 250);

    repository.save(account1);
    repository.save(account2);

    return repository;
  }

}
