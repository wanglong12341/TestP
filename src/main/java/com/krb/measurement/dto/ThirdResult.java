package com.krb.measurement.dto;

import lombok.Data;
import org.apache.poi.ss.formula.functions.T;

@Data
public class ThirdResult {
    private Integer code;
    private T content;
    private String timestamp;
    private String msg;
}
