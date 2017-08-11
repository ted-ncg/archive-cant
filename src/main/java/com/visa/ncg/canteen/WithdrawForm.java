package com.visa.ncg.canteen;

public class WithdrawForm {

    private long accountId;

    private int amount;

    public int getAmount(){
        return amount;
    }

    public long getAccountId(){
        return accountId;
    }

    public void setAmount(int amount){
        this.amount = amount;
    }

    public void setAccountId(long accountId){
        this.accountId = accountId;
    }
}
