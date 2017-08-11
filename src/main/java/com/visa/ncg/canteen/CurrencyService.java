package com.visa.ncg.canteen;

import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nedsouza on 8/11/2017.
 */
public class CurrencyService {


    public CurrencyService() {
    }

    RestTemplate restTemplate = new RestTemplate();

    Currency convertToGBP(int amount){

        String currencyTransferUrl = "http://jitterted-currency-conversion.herokuapp.com/convert?from={from}&to={to}&amount={amount}";

        Map<String, String> params = new HashMap<>();
        String from = "USD";

        params.put("from", from);
        params.put("to", "GBP");
        params.put("amount",String.valueOf(amount));

        ConversionPOJO conversionPOJO = restTemplate
                .getForObject(currencyTransferUrl, ConversionPOJO.class, params);

        Currency currency = new Currency(conversionPOJO, from);

        return currency;
    }

}
