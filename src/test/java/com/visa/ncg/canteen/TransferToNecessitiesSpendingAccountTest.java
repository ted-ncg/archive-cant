package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TransferToNecessitiesSpendingAccountTest {

  @Test
  public void depositingMoneyToAccountIncreasesItsBalance() throws Exception {

    Account necessitiesSpendingAccount =
        new Account("Necessities", 10, null);

    necessitiesSpendingAccount.deposit(20);

    assertThat(necessitiesSpendingAccount.balance())
        .isEqualTo(30);
  }

  @Test
  public void transferPositiveMoneyAdjustsBalances() throws Exception {

    Account bank = new Account("Bank", 200, null);
    Account necessities = new Account("Necessities", 0, null);

    bank.transferTo(necessities, 40);

    assertThat(bank.balance())
        .isEqualTo(160);
    assertThat(necessities.balance())
        .isEqualTo(40);
  }

}
