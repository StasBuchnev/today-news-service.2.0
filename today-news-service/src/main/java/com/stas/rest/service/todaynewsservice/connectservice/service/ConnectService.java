package com.stas.rest.service.todaynewsservice.connectservice.service;

import com.stas.rest.service.todaynewsservice.connectservice.data.Request;
import com.stas.rest.service.todaynewsservice.connectservice.data.Response;
import org.springframework.stereotype.Service;
@Service
public interface ConnectService {

    Response getInfo(Request request);

}
