package com.visa.ncg.canteen;

public class Converter {
    private String currency;

    private int converted;

    public String getCurrency(){
        return currency;
    }

    public void setCurrency(String currency){
        this.currency = currency;
    }

    public int getConverted(){
        return converted;
    }

    public void setConverted(int converted){
        this.converted = converted;
    }
}
