package com.stas.rest.service.todaynewsservice.connectservice.service;

import com.stas.rest.service.todaynewsservice.connectservice.data.Content;
import com.stas.rest.service.todaynewsservice.connectservice.data.Request;
import com.stas.rest.service.todaynewsservice.connectservice.data.Response;
import com.stas.rest.service.todaynewsservice.connectservice.data.WeatherInfo;
import com.stas.rest.service.todaynewsservice.currencyrestservice.CurrencyRestService;
import com.stas.rest.service.todaynewsservice.currencyrestservice.data.Currency;
import com.stas.rest.service.todaynewsservice.weatherrestservice.WeatherRestService;
import com.stas.rest.service.todaynewsservice.weatherrestservice.data.Weather;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConnectServiceImpl implements ConnectService {
    private final WeatherRestService weatherRestService;
    private final CurrencyRestService currencyRestService;

    @Override

    public Response getInfo(Request request) {
        Currency currency = null;
        Weather weather = null;
        if (Boolean.TRUE.equals(request.getCurrencyInfo())) {
            currency = currencyRestService.getCurrency();
        }
        if (Boolean.TRUE.equals(request.getWeatherInfo())) {
            weather = weatherRestService.getWeather();
        }

        Content content = new Content();
        content.setCurrencyInfo(Converter.getCurrencyInfo(currency));
        return Response.builder().content(content).status("ok").build();
    }
}
