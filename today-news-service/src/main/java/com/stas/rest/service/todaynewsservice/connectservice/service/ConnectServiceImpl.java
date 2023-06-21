package com.stas.rest.service.todaynewsservice.connectservice.service;

import com.stas.rest.service.todaynewsservice.connectservice.data.ContentExchangeInfo;
import com.stas.rest.service.todaynewsservice.connectservice.data.Response;
import com.stas.rest.service.todaynewsservice.connectservice.utils.Const;
import com.stas.rest.service.todaynewsservice.currencyrestservice.CurrencyRestService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ConnectServiceImpl implements ConnectService {

    private final CurrencyRestService currencyRestService;

    @Override
    public Response<ContentExchangeInfo> getExchangeInfoByCurrency(String currency) {

        var exchangeFullInfo = currencyRestService.getExchangeInfo();

        var response = new Response<ContentExchangeInfo>();

        if (exchangeFullInfo.getResponseStatus().is2xxSuccessful()) {

            var rate = exchangeFullInfo.getRates().get(currency);

            ContentExchangeInfo content = ContentExchangeInfo.builder()
                    .baseCurrency(exchangeFullInfo.getBaseCurrency())
                    .requestedCurrency(currency)
                    .rate(rate).build();

            response.setContent(content);
            response.setStatus(Const.STATUS_OK);

        } else {
            response.setStatus(Const.STATUS_ERROR);
            response.setErrorMessage(exchangeFullInfo.getErrorMessage());
        }
        return response;
    }
}
