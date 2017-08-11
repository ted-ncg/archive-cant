package com.visa.ncg.canteen;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CurrencyServiceTest {

    @Test
    public  void currencyConversionTest() throws Exception{
        CurrencyService service = new CurrencyService();
        int amountResult = service.convertToGbp(100);
        assertThat(amountResult).isEqualTo(76);
    }
}
