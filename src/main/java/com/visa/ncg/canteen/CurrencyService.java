package com.visa.ncg.canteen;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by djose on 8/11/17.
 */
@Service
public class CurrencyService {

    int convertToGbp(int amount)
    {
        RestTemplate restTemplate = new RestTemplate();

        String url = "http://trampoline.io/convert?from=USD&to=GBP&amount={amount}?json";

        Map<String, Integer> params = new HashMap<>();
        params.put("amount", amount);

        ConvertedCurrency convertedCurrency = restTemplate.getForObject(url, ConvertedCurrency.class, params);

        return convertedCurrency.getConverted();

    }
}
