package com.stas.rest.service.todaynewsservice.connectservice.service;

import com.stas.rest.service.todaynewsservice.connectservice.data.ContentExchangeInfo;
import com.stas.rest.service.todaynewsservice.connectservice.data.Response;
import org.springframework.stereotype.Service;
@Service
public interface ConnectService {

    Response<ContentExchangeInfo>getExchangeInfoByCurrency(String currency);

}
