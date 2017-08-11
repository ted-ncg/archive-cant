package com.visa.ncg.canteen;

import com.visa.ncg.canteen.domain.Account;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class TransferToNecessitiesSpendingAccountTest {

  @Test
  public void depositingMoneyToAccountIncreasesItsBalance() throws Exception {

    Account necessitiesSpendingAccount =
        new Account("Necessities", 10);

    necessitiesSpendingAccount.deposit(20);

    assertThat(necessitiesSpendingAccount.getBalance())
        .isEqualTo(30);
  }

  @Test
  public void transferPositiveMoneyAdjustsBalances() throws Exception {

    Account bank = new Account("Bank", 200);
    Account necessities = new Account("Necessities", 0);

    bank.transferTo(necessities, 40);

    assertThat(bank.getBalance())
        .isEqualTo(160);
    assertThat(necessities.getBalance())
        .isEqualTo(40);
  }

}
