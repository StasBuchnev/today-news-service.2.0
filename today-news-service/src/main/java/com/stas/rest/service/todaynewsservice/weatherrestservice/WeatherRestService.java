package com.stas.rest.service.todaynewsservice.weatherrestservice;

import com.stas.rest.service.todaynewsservice.currencyrestservice.data.Currency;
import com.stas.rest.service.todaynewsservice.weatherrestservice.data.Weather;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
@RequiredArgsConstructor
public class WeatherRestService {
    private final RestTemplate restTemplate;

    private final static String URL_SERVICE = "";

    public Weather getWeather() {
        var response = restTemplate.getForEntity(URL_SERVICE, Weather.class);
        return response.getBody();
    }
}
