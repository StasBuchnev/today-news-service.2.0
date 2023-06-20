package com.stas.rest.service.todaynewsservice.currencyrestservice;

import com.stas.rest.service.todaynewsservice.currencyrestservice.data.Currency;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor

public class CurrencyRestService {
    private final RestTemplate restTemplate;

    private final static String URL_SERVICE = "";

    public Currency getCurrency() {
        var response = restTemplate.getForEntity(URL_SERVICE, Currency.class);
        return response.getBody();
    }

}
