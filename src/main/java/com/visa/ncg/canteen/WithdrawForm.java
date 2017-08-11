package com.visa.ncg.canteen;

/**
 * Created by nedsouza on 8/11/2017.
 */
public class WithdrawForm {
    private int amount;
    private long accountId;

    public WithdrawForm() {
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }


}
