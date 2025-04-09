package com.crms.cloud.service;

import com.crms.cloud.dto.StockOrderEntity;

import java.sql.Timestamp;
import java.util.List;

public interface StockOrderService {
    List<StockOrderEntity> getStockOrderList(Timestamp startCreateTime,Timestamp endCreateTime);

    List<StockOrderEntity> getStockOrderList();

}
