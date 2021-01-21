package com.krb.measurement.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CallBackMessage<T>{
    protected Integer code;
    protected T content;
    protected String timestamp;
    protected String msg;
}