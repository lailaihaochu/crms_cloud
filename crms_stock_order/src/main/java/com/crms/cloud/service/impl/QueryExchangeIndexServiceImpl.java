package com.crms.cloud.service.impl;

import com.crms.cloud.service.QueryExchangeIndexService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class QueryExchangeIndexServiceImpl implements QueryExchangeIndexService {
    @Resource
    RestTemplate restTemplate;
    @Override
    public ResponseEntity getSzExIndexData(String startDate, String endDate, String code, Integer calculationCycle) {
        HttpEntity httpEntity=new HttpEntity(null);
        String url="https://stockapi.com.cn/v1/base/day?code="+code+"&endDate="+endDate+"&startDate="+startDate+"&calculationCycle="+calculationCycle;
        ResponseEntity responseEntity=restTemplate.exchange(url, HttpMethod.GET,httpEntity,String.class);
        return responseEntity;
    }
}
