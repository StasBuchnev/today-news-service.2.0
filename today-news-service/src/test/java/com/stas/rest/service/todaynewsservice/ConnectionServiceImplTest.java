package com.stas.rest.service.todaynewsservice;

import com.stas.rest.service.todaynewsservice.connectservice.service.ConnectServiceImpl;
import com.stas.rest.service.todaynewsservice.connectservice.utils.Const;
import com.stas.rest.service.todaynewsservice.currencyrestservice.CurrencyRestService;
import com.stas.rest.service.todaynewsservice.currencyrestservice.data.ResultExchangeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;

import java.util.Currency;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class ConnectionServiceImplTest {
    @Mock
    private CurrencyRestService currencyRestService;
    private ConnectServiceImpl connectService;

    @BeforeEach
    void setUp() {
        connectService = new ConnectServiceImpl(currencyRestService);
    }

    @Test
    void getExchangeInfoOk() {

        Map<String, Double> ratesMap = Map.of("UAH", 122.3D, "EUR", 0.12D, "RUB", 84.2D);
        when(currencyRestService.getExchangeInfo()).thenReturn(ResultExchangeService.builder()
                .responseStatus(HttpStatus.OK)
                .baseCurrency("USD")
                .rates(ratesMap).build());

        var result = connectService.getExchangeInfoByCurrency("RUB");

        assertEquals(Const.STATUS_OK, result.getStatus());

        assertEquals(84.2d, result.getContent().getRate());
    }

}
