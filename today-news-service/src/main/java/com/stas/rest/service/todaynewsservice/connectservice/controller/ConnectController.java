package com.stas.rest.service.todaynewsservice.connectservice.controller;

import com.stas.rest.service.todaynewsservice.connectservice.data.Request;
import com.stas.rest.service.todaynewsservice.connectservice.data.Response;
import com.stas.rest.service.todaynewsservice.connectservice.service.ConnectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/v1/stas-service/today-news-service")
@RequiredArgsConstructor
public class ConnectController {

    private final ConnectService connectService;

    @RequestMapping(value = "/getInfo", method = RequestMethod.GET)
    public ResponseEntity<Response> getInfoFromService(@RequestBody Request request) {
        return new ResponseEntity<>(connectService.getInfo(request), HttpStatus.OK);

    }

}
