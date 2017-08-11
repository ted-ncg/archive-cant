package com.visa.ncg.canteen;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyService {

    public int convertToGbp(int amount) {
        RestTemplate restTemplate = new RestTemplate();
        String conversionUrl = "http://jitterted-currency-conversion.herokuapp.com/convert?from=USD&to=GBP&amount={amount}";

        Map<String, Integer> params = new HashMap<>();
        params.put("amount", amount);
        ConvertedCurrency convertedCurrency = restTemplate
                .getForObject(conversionUrl, ConvertedCurrency.class, params);
        return convertedCurrency.getConverted();
    }
}
