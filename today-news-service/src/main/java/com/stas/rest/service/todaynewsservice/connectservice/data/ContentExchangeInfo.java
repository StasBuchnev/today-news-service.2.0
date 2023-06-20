package com.stas.rest.service.todaynewsservice.connectservice.data;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ContentExchangeInfo {
    private String baseCurrency;
    private String requestedCurrency;
    private Double rate;
}
