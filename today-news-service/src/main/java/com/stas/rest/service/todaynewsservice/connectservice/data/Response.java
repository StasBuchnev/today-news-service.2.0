package com.stas.rest.service.todaynewsservice.connectservice.data;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response<T> {
    private T content;
    private String status;
    private String errorMessage;
}
