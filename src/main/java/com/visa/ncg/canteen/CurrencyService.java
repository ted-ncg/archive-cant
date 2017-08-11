package com.visa.ncg.canteen;

import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

public class CurrencyService {

    public int convertToGbp(int amount){
        RestTemplate restTemplate = new RestTemplate();
        String converterUrl = "http://jitterted-currency-conversion.herokuapp.com/convert?from=USD&to=GBP&amount={amount}";

        Map<String, String> params = new HashMap<>();
        params.put("amount", "" + amount);
        Converter converter = restTemplate.getForObject(converterUrl, Converter.class, params);


        return converter.getConverted();
    }
}
