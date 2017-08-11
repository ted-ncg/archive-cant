package com.visa.ncg.canteen.domain;

import com.visa.ncg.canteen.conversion.ConversionResponse;
import com.visa.ncg.canteen.web.ConversionResponseWebModel;
import org.springframework.web.client.RestTemplate;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by nedsouza on 8/11/2017.
 */
public class ConversionService {


    public ConversionService() {
    }

    RestTemplate restTemplate = new RestTemplate();

    public int convertToGBP(int amount){

        String currencyTransferUrl = "http://jitterted-currency-conversion.herokuapp.com/convert?from={from}&to={to}&amount={amount}";

        Map<String, String> params = new HashMap<>();
        String from = "USD";

        params.put("from", from);
        params.put("to", "GBP");
        params.put("amount",String.valueOf(amount));

        ConversionResponse conversionResponse = restTemplate
                .getForObject(currencyTransferUrl, ConversionResponse.class, params);

        return conversionResponse.getConverted();
    }

}
