package com.stas.rest.service.todaynewsservice.connectservice.data;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;

import java.util.Currency;
@Getter
@Setter
public class Content {

    private WeatherInfo weatherInfo;
    private CurrencyInfo currencyInfo;
}
