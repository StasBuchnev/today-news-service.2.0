package com.stas.rest.service.todaynewsservice.connectservice.controller;

import com.stas.rest.service.todaynewsservice.connectservice.data.ContentExchangeInfo;
import com.stas.rest.service.todaynewsservice.connectservice.data.Response;
import com.stas.rest.service.todaynewsservice.connectservice.service.ConnectService;
import com.stas.rest.service.todaynewsservice.connectservice.utils.Const;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Objects;

@RestController
@RequestMapping(value = "/v1/stas-service/today-news-service")
@RequiredArgsConstructor
public class ConnectController {

    private final ConnectService connectService;

    private static final Integer BAD_LENGTH_QUERY_PARAM_CURRENCY = 3;

    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    public ResponseEntity<Response<ContentExchangeInfo>> getInfoFromService(@RequestParam String currency) {
        if (Objects.isNull(currency) && BAD_LENGTH_QUERY_PARAM_CURRENCY < currency.length()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
        var result = connectService.getExchangeInfoByCurrency(currency);

        if (Const.STATUS_ERROR.equals(result.getStatus())) {
            return new ResponseEntity<>(result, HttpStatus.INTERNAL_SERVER_ERROR);
        } else {
            return new ResponseEntity<>(result, HttpStatus.OK);
        }

    }

}
