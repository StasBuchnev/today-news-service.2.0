package com.stas.rest.service.todaynewsservice.connectservice.data;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Request {
    private Boolean weatherInfo;
    private Boolean currencyInfo;
}
