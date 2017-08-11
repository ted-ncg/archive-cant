package com.visa.ncg.canteen;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Service
public class CurrencyService {



    public int convertToGbp(int amount){
        RestTemplate restTemplate = new RestTemplate();
        String currencyServiceUrl = "http://jitterted-currency-conversion.herokuapp.com/convert?from=USD&to=GBP&amount={amount}";

        Map<String, String> params = new HashMap<>();
        params.put("amount", Integer.toString(amount));
        CurrencyConversion conversion = restTemplate
                .getForObject(currencyServiceUrl, CurrencyConversion.class, params);


        return (int)conversion.getConverted();
    }
}
