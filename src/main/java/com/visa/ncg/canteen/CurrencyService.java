package com.visa.ncg.canteen;

import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

public class CurrencyService {

    int convertToGbp(int amount) {
        RestTemplate restTemplate = new RestTemplate();
        String trampolineURL = "http://trampoline.io/convert?from=USD&to=GBP&amount={amount}";
        Map<String, String> params = new HashMap<>();
        params.put("amount", String.valueOf(amount));
        Currency converted_amount = restTemplate.getForObject(trampolineURL, Currency.class, params);
        return converted_amount.getConverted().intValueExtract();
    }
}

class Currency {

    String currency;
    BigDecimal converted;

    public BigDecimal getConverted() {
        return converted;
    }

    public void setConverted(BigDecimal converted) {
        this.converted = converted;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
