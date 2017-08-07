package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TransferToNecessitiesSpendingAccountTest {

  @Test
  public void depositingMoneyToAccountIncreasesItsBalance() throws Exception {

    NecessitiesSpendingAccount necessitiesSpendingAccount = new NecessitiesSpendingAccount(10);

    necessitiesSpendingAccount.deposit(20);

    assertThat(necessitiesSpendingAccount.balance())
        .isEqualTo(30);
  }

}
