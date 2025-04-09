package com.crms.cloud.service;

import org.springframework.http.ResponseEntity;

public interface QueryExchangeIndexService {
    public ResponseEntity getSzExIndexData(String createDate,String endDate,String code,Integer calculationCycle);
}
