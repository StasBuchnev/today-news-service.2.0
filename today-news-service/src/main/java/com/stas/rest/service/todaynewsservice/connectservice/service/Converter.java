package com.stas.rest.service.todaynewsservice.connectservice.service;

import com.stas.rest.service.todaynewsservice.connectservice.data.CurrencyInfo;
import com.stas.rest.service.todaynewsservice.currencyrestservice.data.Currency;

public class Converter {

    public static CurrencyInfo getCurrencyInfo(Currency currency) {
        return new CurrencyInfo();
    }

}
