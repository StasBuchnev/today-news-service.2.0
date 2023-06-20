package com.stas.rest.service.todaynewsservice.currencyrestservice.data;

import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.Map;

@Data
@Builder
public class ResultExchangeService {

    private HttpStatus responseStatus;
    private String baseCurrency;
    private Map<String,Double> rates;
    private String errorMessage;

}
