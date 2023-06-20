package com.stas.rest.service.todaynewsservice;

import com.stas.rest.service.todaynewsservice.currencyrestservice.CurrencyRestService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TodayNewsServiceApplicationTests {
    @Autowired
    private CurrencyRestService currencyRestService;

    @Test
    void contextLoads() {
        currencyRestService.getExchangeInfo();
    }

}
