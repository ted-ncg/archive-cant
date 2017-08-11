package com.visa.ncg.canteen.web;

/**
 * Created by nedsouza on 8/11/2017.
 */
public class WithdrawForm {
    private int converted;
    private long accountId;

    public WithdrawForm() {
    }

    public int getConverted() {
        return converted;
    }

    public void setConverted(int converted) {
        this.converted = converted;
    }

    public long getAccountId() {
        return accountId;
    }

    public void setAccountId(long accountId) {
        this.accountId = accountId;
    }


}
