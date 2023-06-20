package com.stas.rest.service.todaynewsservice.connectservice.data;

import lombok.*;

@Data
@Builder
public class Response {
    private Content content;
    private String status;
    private String errorMassage;

}
