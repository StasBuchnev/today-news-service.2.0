package com.stas.rest.service.todaynewsservice.currencyrestservice.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.Map;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class FullExchangeInfo implements Serializable {

    private String disclaimer;
    private String licence;
    private Integer timestamp;
    private String base;
    private Map<String, Double> rates;

}
