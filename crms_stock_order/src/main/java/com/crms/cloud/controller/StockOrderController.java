package com.crms.cloud.controller;

import com.crms.cloud.dto.StockOrderEntity;
import com.crms.cloud.service.StockOrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("stock/order/")
public class StockOrderController {
    @Resource
    StockOrderService stockOrderService;
    @GetMapping("list")
    public ResponseEntity list() throws IOException {
        List<StockOrderEntity> stockOrderEntityList=stockOrderService.getStockOrderList();
        ResponseEntity responseEntity=new ResponseEntity(stockOrderEntityList,HttpStatus.OK);
        return responseEntity;
    }
}
