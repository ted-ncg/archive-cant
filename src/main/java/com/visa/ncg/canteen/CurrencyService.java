package com.visa.ncg.canteen;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyService {

    int convertToGbp(int amount) {
        RestTemplate restTemplate = new RestTemplate();
        String trampolineURL = "http://jitterted-currency-conversion.herokuapp.com/convert?from=USD&to=GBP&amount={amount}";
        Map<String, String> params = new HashMap<>();
        params.put("amount", String.valueOf(amount));
        Currency converted_amount = restTemplate.getForObject(trampolineURL, Currency.class, params);
        return (int) converted_amount.getConverted();
    }
}

class Currency {

    String currency;
    float converted;

    public float getConverted() {
        return converted;
    }

    public void setConverted(float converted) {
        this.converted = converted;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
