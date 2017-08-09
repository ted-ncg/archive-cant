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
    return new AccountRepository();
  }
}
