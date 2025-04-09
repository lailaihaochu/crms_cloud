package com.crms.cloud.context;

import lombok.Data;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@Data
public class StockOrderApplicationContext {
    private String url;
    private String method;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private ResponseEntity rpcResponseEntity;
}
