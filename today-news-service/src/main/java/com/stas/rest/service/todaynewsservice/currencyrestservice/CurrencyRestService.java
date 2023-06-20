package com.stas.rest.service.todaynewsservice.currencyrestservice;

import com.stas.rest.service.todaynewsservice.currencyrestservice.data.FullExchangeInfo;
import com.stas.rest.service.todaynewsservice.currencyrestservice.data.ResultExchangeService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@Component
@RequiredArgsConstructor
public class CurrencyRestService {
    @Value("${rest.exchange-service.url}")
    private String url;
    @Value("${rest.exchange-service.token}")
    private String token;



    public ResultExchangeService getExchangeInfo() {
        RestTemplate restTemplate = new RestTemplate();

        Map<String, String> queryParams = new HashMap<>();
        queryParams.put("app_id", token);
        queryParams.put("prettyprint", "false");
        queryParams.put("show_alternative", "false");

        var result = ResultExchangeService.builder();

        try {
            var response = restTemplate.getForEntity(url, FullExchangeInfo.class, queryParams);

            result.responseStatus(response.getStatusCode())
                    .rates(response.getBody().getRates())
                    .baseCurrency(response.getBody().getBase());

        } catch (HttpClientErrorException e) {
            result.responseStatus(e.getStatusCode())
                    .errorMessage(e.getMessage());
        }

        return result.build();
    }


}
